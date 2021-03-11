package com.excilys.tondeuse;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Tondeuse;
import com.excilys.tondeuse.utils.IOUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ModelException
    {
        System.out.println( "Hello World!" );
        Carte carte = new Carte(3,3);
        Tondeuse tondeuse1 = new Tondeuse(1, 2, Direction.West);
        carte.getTondeuses().add(tondeuse1);
        Tondeuse tondeuse2 = new Tondeuse(2,0, Direction.North);
        carte.getTondeuses().add(tondeuse2);
        IOUtils iOUtils = new IOUtils();

        iOUtils.afficherSortie(carte);
    }
}
