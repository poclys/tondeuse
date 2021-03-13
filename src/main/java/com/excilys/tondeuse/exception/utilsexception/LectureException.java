package com.excilys.tondeuse.exception.utilsexception;

public class LectureException extends UtilsException {
    
    public LectureException(String msg){
        super("Une erreur est survenu lors de" +
        "la lecture du fichier : " + msg);
    }

}
