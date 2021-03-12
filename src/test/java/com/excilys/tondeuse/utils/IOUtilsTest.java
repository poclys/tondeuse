package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Tondeuse;

import org.junit.jupiter.api.Test;

class IOUtilsTest {

    @Test
    void read_file_end_to_end() throws IOException, UtilsException{
        FileInputStream fis = new FileInputStream("src/test/resources/sample.txt");
        InputStream targetStream = fis;
        IOUtils ioUtils = new IOUtils();
        Carte carte = ioUtils.readFile(targetStream);
        ioUtils.afficherSortie(carte);
    }
    

    @Test
    void afficher_carte() throws ModelException{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream orinalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Carte carte = new Carte(3,3);
        Tondeuse tondeuse1 = new Tondeuse(1, 2, Direction.WEST);
        carte.getTondeuses().add(tondeuse1);
        Tondeuse tondeuse2 = new Tondeuse(2,0, Direction.NORTH);
        carte.getTondeuses().add(tondeuse2);
        IOUtils iOUtils = new IOUtils();

        iOUtils.afficherSortie(carte);
        assertEquals("1 2 W\n2 0 N\n", outContent.toString());

        System.setOut(orinalOut);
    }

 
}
