package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.exception.utilsexception.CarteParsingException;
import com.excilys.tondeuse.modele.Carte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Gère le traitement des Strings pour initialiser les Cartes.
 */
@Service
public class CarteUtils {
  PointUtils pointUtils;

  @Autowired
  public CarteUtils(PointUtils pointUtils){
    this.pointUtils = pointUtils;
  }

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
      throw new CarteParsingException();
    }
    return new Carte(pointUtils.stringToPoint(size));
  }
}
