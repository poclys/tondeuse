package com.excilys.tondeuse.exception.modelexception;

public class HauteurNegativeException extends ModelException{
    
    public HauteurNegativeException(){
        super("La position selon l'axe Nord-Sud (y) ne peut pas être négative !");
    }

}
