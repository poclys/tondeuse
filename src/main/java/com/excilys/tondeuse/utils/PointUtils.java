package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.modelexception.ModelException;
import com.excilys.tondeuse.exception.utilsexception.PointParsingException;
import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Point;

import org.springframework.stereotype.Service;

/**
 * Gère le traitement des Strings pour obtenir des points.
 */
@Service
public class PointUtils {

  /**
   * Transforme un tableau de String en un Point.
   *
   * @param infos un tableau de String d'au moins deux String
   * @return un point
   * @throws UtilsException Si une des deux première String est mal formé
   */
  public Point stringToPoint(String[] infos) throws UtilsException {
    try {
      return new Point(Integer.parseInt(infos[0]), Integer.parseInt(infos[1]));
    } catch (NumberFormatException e) {
      throw new PointParsingException();
    } catch (ModelException e) {
      throw new UtilsException(e.getMessage());
    }
  }
}
