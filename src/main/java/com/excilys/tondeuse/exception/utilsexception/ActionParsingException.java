package com.excilys.tondeuse.exception.utilsexception;

public class ActionParsingException extends UtilsException {
    
    public ActionParsingException(){
        super("une des actions lu ne correspond à rien");
    }

}
