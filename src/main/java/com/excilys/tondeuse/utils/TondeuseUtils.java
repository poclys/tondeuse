package com.excilys.tondeuse.utils;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Tondeuse;

public class TondeuseUtils {

    /**
     * Fait tourner vers la gauche la tondeuse
     * 
     * @param tondeuse la tondeuse qui change de direction
     */
    public void tournerAGauche(Tondeuse tondeuse) {
        switch (tondeuse.getDirection()) {
            case North:
                tondeuse.setDirection(Direction.West);
                break;
            case West:
                tondeuse.setDirection(Direction.South);
                break;
            case South:
                tondeuse.setDirection(Direction.East);
                break;
            case East:
                tondeuse.setDirection(Direction.North);
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
            case North:
                tondeuse.setDirection(Direction.East);
                break;
            case West:
                tondeuse.setDirection(Direction.North);
                break;
            case South:
                tondeuse.setDirection(Direction.West);
                break;
            case East:
                tondeuse.setDirection(Direction.South);
                break;
        }
    }

    /**
     * Fait avancer la tondeuse dans la direction dans laquelle elle est orientée
     * @param tondeuse la tondeuse qui avance
     * @param carte la carte sur laquelle est la tondeuse
     * @throws UtilsException si la tondeuse sort de la carte
     */
    public void avancer(Tondeuse tondeuse, Carte carte) throws UtilsException {
        switch (tondeuse.getDirection()){
            case North :  
                avanceToNorth(tondeuse, carte);
                break;
            case West :
                avanceToWest(tondeuse, carte);
                break;
            case South : 
                avanceToSouth(tondeuse, carte);
                break;
            case East :
                avanceToEast(tondeuse, carte);
                break;
        }
    }

    /**
     * Fait avancer la tondeuse d'une position vers l'Est ( x+1 )
     * @param tondeuse la tondeuse qui doit avancer
     * @param carte la carte sur laquelle est la tondeuse
     * @throws UtilsException si la tondeuse sort de la carte
     */
    private void avanceToEast(Tondeuse tondeuse, Carte carte) throws UtilsException {
        try {
            int actuelX = tondeuse.getCoordonnees().getX();
            if (actuelX + 1 > carte.getLongueur()){
                throw new UtilsException("La position selon l'axe Ouest-Est (x) ne peut pas "
                + " être plus grande que la hauteur de la carte " + carte.getLongueur() + " !");
            }
            tondeuse.getCoordonnees().setX(actuelX + 1);
        } catch (ModelException e) {
            throw new UtilsException(e.getMessage());
        }
    }

    /**
     * Fait avancer la tondeuse d'une position vers le Sud ( y-1 )
     * @param tondeuse la tondeuse qui doit avancer
     * @param carte la carte sur laquelle est la tondeuse
     * @throws UtilsException si la tondeuse sort de la carte
     */
    private void avanceToSouth(Tondeuse tondeuse, Carte carte) throws UtilsException {
        try {
            int actuelY = tondeuse.getCoordonnees().getY();
            if (actuelY - 1 > carte.getHauteur()){
                throw new UtilsException("La position selon l'axe Nord-Sud (y) ne peut pas "
                + " être plus grande que la hauteur de la carte " + carte.getHauteur() + " !");
            }
            tondeuse.getCoordonnees().setY(actuelY - 1);
        } catch (ModelException e) {
            throw new UtilsException(e.getMessage());
        }
    }

    /**
     * Fait avancer la tondeuse d'une position vers l'Ouest ( x-1 )
     * @param tondeuse la tondeuse qui doit avancer
     * @param carte la carte sur laquelle est la tondeuse
     * @throws UtilsException si la tondeuse sort de la carte
     */
    private void avanceToWest(Tondeuse tondeuse, Carte carte) throws UtilsException {
        try {
            int actuelX = tondeuse.getCoordonnees().getX();
            if (actuelX - 1 > carte.getLongueur()){
                throw new UtilsException("La position selon l'axe Ouest-Est (x) ne peut pas "
                + " être plus grande que la hauteur de la carte " + carte.getLongueur() + " !");
            }
            tondeuse.getCoordonnees().setX(actuelX - 1);
        } catch (ModelException e) {
            throw new UtilsException(e.getMessage());
        }
    }

    /**
     * Fait avancer la tondeuse d'une position vers le Nord ( y+1 )
     * @param tondeuse la tondeuse qui doit avancer
     * @param carte la carte sur laquelle est la tondeuse
     * @throws UtilsException si la tondeuse sort de la carte
     */
    private void avanceToNorth(Tondeuse tondeuse, Carte carte) throws UtilsException {
        try { 
            int actuelY = tondeuse.getCoordonnees().getY();
            if (actuelY + 1 > carte.getHauteur()){
                throw new UtilsException("La position selon l'axe Nord-Sud (y) ne peut pas "
                + " être plus grande que la hauteur de la carte " + carte.getHauteur() + " !");
            }
            tondeuse.getCoordonnees().setY(actuelY + 1);
        } catch (ModelException e) {
            throw new UtilsException(e.getMessage());
        }
    }
    

}