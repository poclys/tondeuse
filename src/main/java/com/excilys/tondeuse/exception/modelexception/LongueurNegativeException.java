package com.excilys.tondeuse.exception.modelexception;

public class LongueurNegativeException extends ModelException {
    
    public LongueurNegativeException(){
        super("La position selon l'axe Ouest-Est (x) ne peut pas être négative !");
    }

}
