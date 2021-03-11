package com.excilys.tondeuse.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Tondeuse;

public class IOUtils {
    
    /**
     * affiche les positions des tondeuses sans afficher la taille de la carte
     * @param carte la carte dont on affiche le résultat
     */
    public void afficherSortie(Carte carte){
        for (Tondeuse tondeuse : carte.getTondeuses()){
            System.out.println(tondeuse);
        }
    }

    public String readFile(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader 
            = new BufferedReader(new InputStreamReader(inputStream))){
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    // TODO : traiter les lignes 
                    resultStringBuilder.append(line).append('\n');
                }
        }
        return resultStringBuilder.toString();
    }

    /**
     *  Initialise et retourne la carte correspondant au coordonnées de
     *  la case du coin supérieur droit
     * @param line les coordonnées de la case du coin supérieur droit
     * @return la carte initialisé
     * @throws UtilsException l'entrée est mal formé
     */
    public Carte initCarte(String line) throws UtilsException{
        String[] size = line.split(" ");
        if (size.length != 2){
            throw new UtilsException("la ligne ne possède pas 2 coordonnées");
        }
        try {
            return new Carte(Integer.parseInt(size[0]),Integer.parseInt(size[1]));
        } catch (NumberFormatException e){
            throw new UtilsException("La ligne contenant les coordonées de la case "
            + " du coin supérieur droit est mal formée");
        }
    }

}
