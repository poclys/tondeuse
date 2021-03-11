package com.excilys.tondeuse.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Tondeuse;

/**
 * Gère tout ce qui concerne la lecture et l'écriture
 */
public class IOUtils {
    
    /**
     * affiche les positions des tondeuses sans afficher la taille de la carte
     * @param carte la carte dont on affiche le résultat
     */
    public void afficherSortie(Carte carte){
        for (Tondeuse tondeuse : carte.getTondeuses()){
            System.out.println(tondeuse);
        }
    }

    public Carte readFile(InputStream inputStream) throws IOException, UtilsException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader 
            = new BufferedReader(new InputStreamReader(inputStream))){
                Carte carte = lireLigneInialisationCarte(bufferedReader);
                
                lireDeuxLignesConcernantTondeuse(bufferedReader, carte);
                
                return carte;
        }
    }

    /**
     * Lis les deux premières lignes de l'entrée, initialise et déplace la tondeuse puis l'ajoute à la carte
     * @param bufferedReader lié à l'entrée contenant les informations
     * @param carte la carte sur laquelle va se déplacer la tondeuse
     * @throws UtilsException remonte les exceptions rencontrés
     */
    private void lireDeuxLignesConcernantTondeuse(BufferedReader bufferedReader, Carte carte) throws UtilsException {
        String initialisationTondeuse;
        try {
            while ((initialisationTondeuse = bufferedReader.readLine()) != null){
                Tondeuse tondeuse = new TondeuseUtils().initTondeuse(initialisationTondeuse);
                String deplacement = bufferedReader.readLine();
                lectureDeplacement(deplacement, tondeuse, carte);
                carte.getTondeuses().add(tondeuse);
            }
        } catch (IOException e) {
            throw new UtilsException("Une erreur est survenu lors de" 
            + "la lecture du fichier : " + e.getMessage());
        }
    }

    /**
     * Lis la ligne concernant l'initalisation de la carte et retourne la carte qui y correspond
     * @param bufferedReader lié à l'entrée contenant les informations
     * @return la carte initialisée
     * @throws UtilsException remonte les exceptions rencontrés
     */
    private Carte lireLigneInialisationCarte(BufferedReader bufferedReader) throws UtilsException {
        try {
            String initialisationCarte = bufferedReader.readLine();
            return new CarteUtils().initCarte(initialisationCarte);
        } catch (UtilsException | IOException e) {
            throw new UtilsException("Une erreur est survenu lors de" 
            + "la lecture du fichier : " + e.getMessage());
        }
    }

   

    
    

    

    /**
     * Effectue les déplacements qui correspondent à la ligne
     * En cas d'erreur lors d'un déplacement, on passe au suivant
     * @param line la ligne des déplacements
     * @param tondeuse la tondeuse associé à ces déplacements
     * @param carte la carte à laquelle on associera la tondeuse
     */
    public void lectureDeplacement(String line, Tondeuse tondeuse, Carte carte){
        TondeuseUtils tondeuseUtils = new TondeuseUtils();
        for (int i = 0; i < line.length(); i++){
            char lettre = line.charAt(i);
            switch(lettre){
                case 'A':
                    try {
                        tondeuseUtils.avancer(tondeuse, carte);
                    } catch (UtilsException e) {
                    
                    }
                    break;
                case 'G':
                    tondeuseUtils.tournerAGauche(tondeuse);
                    break;
                case 'D':
                    tondeuseUtils.tournerADroite(tondeuse);
                    break;
            }
        }
    }

}
