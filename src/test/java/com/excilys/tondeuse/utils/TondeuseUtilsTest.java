package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Tondeuse;

import org.junit.jupiter.api.Test;

public class TondeuseUtilsTest {

    @Test
    public void tourner_a_gauche_north() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.North);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.West);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void tourner_a_gauche_west() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.West);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.South);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void tourner_a_gauche_south() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.South);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.East);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void tourner_a_gauche_east() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.East);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.North);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }



    @Test
    public void tourner_a_droite_north() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.North);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.East);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void tourner_a_droite_west() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.West);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.North);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void tourner_a_droite_south() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.South);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.West);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void tourner_a_droite_east() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.East);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.South);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void avancer_vers_l_est() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.East);
        Tondeuse tondeuseExpected = new Tondeuse(1,0,Direction.East);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void avancer_vers_l_est_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.East);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    public void avancer_vers_le_nord() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.North);
        Tondeuse tondeuseExpected = new Tondeuse(0,1,Direction.North);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void avancer_vers_le_nord_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.North);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    public void avancer_vers_l_ouest() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.West);
        Tondeuse tondeuseExpected = new Tondeuse(2,0,Direction.West);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void avancer_vers_l_ouest_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.West);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    public void avancer_vers_le_sud() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.South);
        Tondeuse tondeuseExpected = new Tondeuse(0,2,Direction.South);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    public void avancer_vers_le_sud_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.South);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }


}