package com.excilys.tondeuse.exception.utilsexception;

public class TondeuseParsingException extends UtilsException {
    
    public TondeuseParsingException(){
        super("la ligne ne possède pas 2 coordonnées et une direction");
    }

}
