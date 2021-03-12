package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Point;
import com.excilys.tondeuse.modele.Tondeuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Gère tout les mouvements possible d'une Tondeuse ainsi que le traitement de
 * String pour définir un mouvement ou une initialisation de Tondeuse.
 */
@Service
public class TondeuseUtils {
  PointUtils pointUtils;
  DirectionUtils directionUtils;

  @Autowired
  public TondeuseUtils(PointUtils pointUtils, DirectionUtils directionUtils){
    this.pointUtils = pointUtils;
    this.directionUtils = directionUtils;
  }

  /**
   * Fait tourner vers la gauche la tondeuse.
   *
   * @param tondeuse la tondeuse qui change de direction
   */
  public void tournerAGauche(Tondeuse tondeuse) {
    switch (tondeuse.getDirection()) {
      case NORTH:
        tondeuse.setDirection(Direction.WEST);
        break;
      case WEST:
        tondeuse.setDirection(Direction.SOUTH);
        break;
      case SOUTH:
        tondeuse.setDirection(Direction.EAST);
        break;
      case EAST:
        tondeuse.setDirection(Direction.NORTH);
        break;
    }
  }

  /**
   * Fait tourner vers la droite la tondeuse
   *
   * @param tondeuse la tondeuse qui change de direction
   */
  public void tournerADroite(Tondeuse tondeuse) {
    switch (tondeuse.getDirection()) {
      case NORTH:
        tondeuse.setDirection(Direction.EAST);
        break;
      case WEST:
        tondeuse.setDirection(Direction.NORTH);
        break;
      case SOUTH:
        tondeuse.setDirection(Direction.WEST);
        break;
      case EAST:
        tondeuse.setDirection(Direction.SOUTH);
        break;
    }
  }

  /**
   * Fait avancer la tondeuse dans la direction dans laquelle elle est orientée
   *
   * @param tondeuse la tondeuse qui avance
   * @param carte    la carte sur laquelle est la tondeuse
   * @throws UtilsException si la tondeuse sort de la carte
   */
  public void avancer(Tondeuse tondeuse, Carte carte) throws UtilsException {
    switch (tondeuse.getDirection()) {
      case NORTH:
        avanceToNorth(tondeuse, carte);
        break;
      case WEST:
        avanceToWest(tondeuse, carte);
        break;
      case SOUTH:
        avanceToSouth(tondeuse, carte);
        break;
      case EAST:
        avanceToEast(tondeuse, carte);
        break;
    }
  }

  /**
   * Fait avancer la tondeuse d'une position vers l'Est ( x+1 )
   *
   * @param tondeuse la tondeuse qui doit avancer
   * @param carte    la carte sur laquelle est la tondeuse
   * @throws UtilsException si la tondeuse sort de la carte
   */
  private void avanceToEast(Tondeuse tondeuse, Carte carte)
    throws UtilsException {
    try {
      int actuelX = tondeuse.getCoordonnees().getX();
      if (actuelX + 1 > carte.getLongueur()) {
        throw new UtilsException(
          "La position selon l'axe Ouest-Est (x) ne peut pas " +
          " être plus grande que la hauteur de la carte " +
          carte.getLongueur() +
          " !"
        );
      }
      tondeuse.getCoordonnees().setX(actuelX + 1);
    } catch (ModelException e) {
      throw new UtilsException(e.getMessage());
    }
  }

  /**
   * Fait avancer la tondeuse d'une position vers le Sud ( y-1 )
   *
   * @param tondeuse la tondeuse qui doit avancer
   * @param carte    la carte sur laquelle est la tondeuse
   * @throws UtilsException si la tondeuse sort de la carte
   */
  private void avanceToSouth(Tondeuse tondeuse, Carte carte)
    throws UtilsException {
    try {
      int actuelY = tondeuse.getCoordonnees().getY();
      if (actuelY - 1 > carte.getHauteur()) {
        throw new UtilsException(
          "La position selon l'axe Nord-Sud (y) ne peut pas " +
          " être plus grande que la hauteur de la carte " +
          carte.getHauteur() +
          " !"
        );
      }
      tondeuse.getCoordonnees().setY(actuelY - 1);
    } catch (ModelException e) {
      throw new UtilsException(e.getMessage());
    }
  }

  /**
   * Fait avancer la tondeuse d'une position vers l'Ouest ( x-1 )
   *
   * @param tondeuse la tondeuse qui doit avancer
   * @param carte    la carte sur laquelle est la tondeuse
   * @throws UtilsException si la tondeuse sort de la carte
   */
  private void avanceToWest(Tondeuse tondeuse, Carte carte)
    throws UtilsException {
    try {
      int actuelX = tondeuse.getCoordonnees().getX();
      if (actuelX - 1 > carte.getLongueur()) {
        throw new UtilsException(
          "La position selon l'axe Ouest-Est (x) ne peut pas " +
          " être plus grande que la hauteur de la carte " +
          carte.getLongueur() +
          " !"
        );
      }
      tondeuse.getCoordonnees().setX(actuelX - 1);
    } catch (ModelException e) {
      throw new UtilsException(e.getMessage());
    }
  }

  /**
   * Fait avancer la tondeuse d'une position vers le Nord ( y+1 )
   *
   * @param tondeuse la tondeuse qui doit avancer
   * @param carte    la carte sur laquelle est la tondeuse
   * @throws UtilsException si la tondeuse sort de la carte
   */
  private void avanceToNorth(Tondeuse tondeuse, Carte carte)
    throws UtilsException {
    try {
      int actuelY = tondeuse.getCoordonnees().getY();
      if (actuelY + 1 > carte.getHauteur()) {
        throw new UtilsException(
          "La position selon l'axe Nord-Sud (y) ne peut pas " +
          " être plus grande que la hauteur de la carte " +
          carte.getHauteur() +
          " !"
        );
      }
      tondeuse.getCoordonnees().setY(actuelY + 1);
    } catch (ModelException e) {
      throw new UtilsException(e.getMessage());
    }
  }

  /**
   * Initialise et retourne une tondeuse correspondant à la ligne rentrée
   *
   * @param line la ligne contenant les informations de la tondeuse
   * @return la tondeuse correspondant aux informations
   * @throws UtilsException les informations sont malformés
   */
  public Tondeuse initTondeuse(final String line) throws UtilsException {
    String[] infos = line.split(" ");
    if (infos.length != 3) {
      throw new UtilsException(
        "la ligne ne possède pas 2 coordonnées et une direction"
      );
    }
    Point coordonnees = pointUtils.stringToPoint(infos);
    Direction direction = directionUtils.stringToDirection(infos[2]);
    return new Tondeuse(coordonnees, direction);
  }
}
