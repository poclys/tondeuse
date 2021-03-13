package com.excilys.tondeuse.exception.utilsexception;

public class LongueurTropGrandeException extends UtilsException {
    
    public LongueurTropGrandeException(){
        super( "La position selon l'axe Ouest-Est (x) ne peut pas " +
        " être plus grande que la hauteur de la carte ");
    }

}
