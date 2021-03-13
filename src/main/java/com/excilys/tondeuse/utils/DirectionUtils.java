package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.exception.utilsexception.DirectionParsingException;
import com.excilys.tondeuse.modele.Direction;

import org.springframework.stereotype.Service;

/**
 * Gestion des Strings pour obtenir une Direction.
 */
@Service
public class DirectionUtils {

  /**
   * transforme un String en la direction correspondante.
   *
   * @param direction un String qui doit être E, S, W ou N
   * @return la direction correspondante
   * @throws UtilsException la String en entrée ne
   * correspond pas à une direction.
   */
  public Direction stringToDirection(String direction)
    throws UtilsException {
    switch (direction) {
      case "E":
        return Direction.EAST;
      case "W":
        return Direction.WEST;
      case "N":
        return Direction.NORTH;
      case "S":
        return Direction.SOUTH;
      default:
        throw new DirectionParsingException();
    }
  }
}
