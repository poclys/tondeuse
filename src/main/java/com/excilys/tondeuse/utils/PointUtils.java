package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Point;

/**
 * Gère le traitement des Strings pour obtenir des points.
 */
public class PointUtils {

  /**
   * Transforme un tableau de String en un Point.
   *
   * @param infos un tableau de String d'au moins deux String
   * @return un point
   * @throws UtilsException Si une des deux première String est mal formé
   */
  public Point stringToPoint(final String[] infos) throws UtilsException {
    try {
      return new Point(Integer.parseInt(infos[0]), Integer.parseInt(infos[1]));
    } catch (NumberFormatException e) {
      throw new UtilsException(
        "La ligne contenant les coordonées est mal formée"
      );
    } catch (ModelException e) {
      throw new UtilsException(e.getMessage());
    }
  }
}
