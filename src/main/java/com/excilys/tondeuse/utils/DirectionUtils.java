package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Direction;

public class DirectionUtils {
    /**
     * transforme un String en la direction correspondante
     * @param direction un String qui doit être E, S, W ou N
     * @return la direction correspondante
     * @throws UtilsException la String en entrée ne correspond pas à une direction
     */
    public Direction stringToDirection(String direction) throws UtilsException {
        switch (direction){
            case "E":
                return Direction.East;
            case "W":
                return Direction.West;
            case "N":
                return Direction.North;
            case "S":
                return Direction.South;
            default :
                throw new UtilsException("la direction de la tondeuse est incorrecte !");
        }
        
    }
}
