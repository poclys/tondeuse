package com.excilys.tondeuse.exception.utilsexception;

public class HauteurTropGrandeException extends UtilsException {
    
    public HauteurTropGrandeException(){
        super("La position selon l'axe Nord-Sud (y) ne peut pas " +
        " être plus grande que la hauteur de la carte");
    }

}
