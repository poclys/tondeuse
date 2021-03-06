package com.excilys.tondeuse.cli;

import com.excilys.tondeuse.AppConfiguration;
import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Tondeuse;
import com.excilys.tondeuse.utils.CarteUtils;
import com.excilys.tondeuse.utils.IOUtils;
import com.excilys.tondeuse.utils.TondeuseUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CLI {

  CarteUtils carteUtils;
  IOUtils ioUtils;
  TondeuseUtils tondeuseUtils;

  public CLI() {
    ApplicationContext context = new AnnotationConfigApplicationContext(
      AppConfiguration.class
    );
    this.carteUtils = context.getBean(CarteUtils.class);
    this.ioUtils = context.getBean(IOUtils.class);
    this.tondeuseUtils = context.getBean(TondeuseUtils.class);
  }

  public static void main(String[] args) {
    CLI cli = new CLI();
    Scanner sin = new Scanner(System.in);
    System.out.println("Bienvenue sur Mower by MowItNow !");
    boolean stopTheProgram = false;
    while (!stopTheProgram) {
      Menu choice = cli.menu(sin);
      if (choice == null) {
        choice = Menu.RIEN;
      }
      stopTheProgram = menuSwitch(cli, sin, stopTheProgram, choice);
    }
    sin.close();
  }

  /**
   * Le switch qui gère le menu du programme.
   * @param cli une instance de CLI
   * @param sin l'entrée par laquelle l'utilisateur communique avec le programme
   * @param stopTheProgram permet de savoir si le programme doit s'arreter
   * @param choice le choix de l'utilisateur
   * @return si le programme doit s'arreter ou non
   */
  private static boolean menuSwitch(
    CLI cli,
    Scanner sin,
    boolean stopTheProgram,
    Menu choice
  ) {
    switch (choice) {
      case FICHIER_PATH:
        cli.choixDuFichier(sin);
        break;
      case DATA:
        cli.menuData(sin);
        break;
      case FICHIER_DEFAULT:
        cli.menuFichierDefault();
        break;
      case STOP_PROGRAMME:
        stopTheProgram = cli.menuStopProgramme();
        break;
      default:
    }
    return stopTheProgram;
  }

  private boolean menuStopProgramme() {
    boolean stopTheProgram;
    System.out.println(
      "Arret du programme, merci " +
      "d'avoir utilisé Mower, à une prochaine fois"
    );
    stopTheProgram = true;
    return stopTheProgram;
  }

  private void menuFichierDefault() {
    try {
      this.ouvertureDuFichierLectureAffichage("src/main/resources/sample.txt");
    } catch (IOException | UtilsException e) {
      System.out.println(e.getMessage());
    }
  }

  private void menuData(Scanner sin) {
    try {
      Carte carte = this.readAndUseData(sin);
      ioUtils.afficherSortie(carte);
    } catch (UtilsException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Affiche les choix et retourne celui choisi par l'utilisateur.
   * @return le choix de l'utilisateur
   */
  public Menu menu(Scanner sin) {
    System.out.println("Vous pouvez :");
    System.out.println(
      "1 - Donner un fichier qui contient " +
      "les informations de la carte et des tondeuses"
    );
    System.out.println("2 - Tout rentrer à la main");
    System.out.println(
      "3 - Utiliser le fichier par default " +
      "situé dans src/main/resources/sample.txt"
    );
    System.out.println("4 - Arreter le programme");
    System.out.println("Quel est votre choix  ?");
    Menu result;
    try {
      result = Menu.valueOf(Integer.parseInt(sin.nextLine()));
    } catch (NumberFormatException e) {
      result = Menu.RIEN;
    }
    return result;
  }

  /**
   * Lis les données correspondant à la taille de la carte,
   * la position initiale des tondeuse et leur déplacement.
   * Effectue les déplacements, ajoute les tondeuses à la carte
   * et retourne la carte
   * @param sin l'entrée par laquelle l'utilisateur communique avec
   * le programme
   * @return la carte avec ses tondeuses
   * @throws UtilsException remonte les erreurs rencontrées
   */
  public Carte readAndUseData(Scanner sin) throws UtilsException {
    System.out.println("Entrez les coordonnées de la case supérieur droite :");
    String initialisationCarte = sin.nextLine();
    Carte result = carteUtils.initCarte(initialisationCarte);

    System.out.println(
      "Entrez les coordonnées initiales de la tondeuse " +
      "( laissez vide si plus de tondeuse )"
    );
    String position = sin.nextLine();
    while (!position.equals("")) {
      position = lectureTondeuseEtDeplacement(sin, result, position);
    }
    return result;
  }

  private String lectureTondeuseEtDeplacement(
    Scanner sin,
    Carte carte,
    String position
  )
    throws UtilsException {
    Tondeuse tondeuse = tondeuseUtils.initTondeuse(position, carte);
    String deplacement = sin.nextLine();
    ioUtils.lectureDeplacement(deplacement, tondeuse, carte);
    carte.getTondeuses().add(tondeuse);
    System.out.println(
      "Entrez les coordonnées initiales de la tondeuse " +
      "( laissez vide si plus de tondeuse )"
    );
    position = sin.nextLine();
    return position;
  }

  /**
   * Demande le fichier à utiliser, l'interprette et affiche
   * la position finale des tondeuses.
   */
  public void choixDuFichier(Scanner sin) {
    System.out.println("Veuillez entrer le chemin du fichier :");
    try {
      String fichierPath = sin.nextLine();
      ouvertureDuFichierLectureAffichage(fichierPath);
    } catch (FileNotFoundException e) {
      System.out.println("Le fichier n'a pas été trouvé !");
    } catch (IOException e) {
      System.out.println("Erreur : " + e.getMessage());
    } catch (UtilsException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Ouvre le fichier, initialise la carte, les tondeuses, joue les
   * instructions puis affiche le résultat.
   * @param fichierPath la localisation du fichier
   * @throws FileNotFoundException le fichier n'a pas été trouvé
   * @throws IOException erreur lors de la lecture du fichier
   * @throws UtilsException remonte les erreurs
   */
  private void ouvertureDuFichierLectureAffichage(String fichierPath)
    throws IOException, UtilsException {
    FileInputStream fis = new FileInputStream(fichierPath);
    InputStream targetStream = fis;
    Carte carte = ioUtils.readFile(targetStream);
    ioUtils.afficherSortie(carte);
  }
}
