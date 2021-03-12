package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;

/**
 * Gère le traitement des Strings pour initialiser les Cartes.
 */
public class CarteUtils {

  /**
   * Initialise et retourne la carte correspondant au coordonnées de la case du
   * coin supérieur droit.
   *
   * @param line les coordonnées de la case du coin supérieur droit
   * @return la carte initialisé
   * @throws UtilsException l'entrée est mal formé
   */
  public Carte initCarte(String line) throws UtilsException {
    String[] size = line.split(" ");
    if (size.length != 2) {
      throw new UtilsException("la ligne ne possède pas 2 coordonnées");
    }
    return new Carte(new PointUtils().stringToPoint(size));
  }
}
