package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Tondeuse;

import org.junit.jupiter.api.Test;

public class IOUtilsTest {
    

    @Test
    public void afficher_carte() throws ModelException{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream orinalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Carte carte = new Carte(3,3);
        Tondeuse tondeuse1 = new Tondeuse(1, 2, Direction.West);
        carte.getTondeuses().add(tondeuse1);
        Tondeuse tondeuse2 = new Tondeuse(2,0, Direction.North);
        carte.getTondeuses().add(tondeuse2);
        IOUtils iOUtils = new IOUtils();

        iOUtils.afficherSortie(carte);
        assertEquals("1 2 W\n2 0 N\n", outContent.toString());

        System.setOut(orinalOut);
    }

 
}
