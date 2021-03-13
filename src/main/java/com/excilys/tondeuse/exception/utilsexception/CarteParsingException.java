package com.excilys.tondeuse.exception.utilsexception;

public class CarteParsingException extends UtilsException {
    
    public CarteParsingException(){
        super("la ligne ne possède pas 2 coordonnées");
    }

}
