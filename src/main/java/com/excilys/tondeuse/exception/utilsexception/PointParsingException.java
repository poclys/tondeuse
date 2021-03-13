package com.excilys.tondeuse.exception.utilsexception;

public class PointParsingException extends UtilsException {
    
    public PointParsingException(){
        super("La ligne contenant les coordonées est mal formée");
    }

}
