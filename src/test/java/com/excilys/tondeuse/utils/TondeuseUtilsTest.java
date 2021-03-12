package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Tondeuse;

import org.junit.jupiter.api.Test;

class TondeuseUtilsTest {

    @Test
    void tourner_a_gauche_north() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.NORTH);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.WEST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_gauche_west() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.WEST);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.SOUTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_gauche_south() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.SOUTH);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.EAST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_gauche_east() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.EAST);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.NORTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }



    @Test
    void tourner_a_droite_north() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.NORTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.EAST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_droite_west() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.WEST);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.NORTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_droite_south() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.SOUTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.WEST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_droite_east() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.EAST);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.SOUTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_l_est() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.EAST);
        Tondeuse tondeuseExpected = new Tondeuse(1,0,Direction.EAST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_l_est_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.EAST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    void avancer_vers_le_nord() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.NORTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,1,Direction.NORTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_le_nord_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.NORTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    void avancer_vers_l_ouest() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.WEST);
        Tondeuse tondeuseExpected = new Tondeuse(2,0,Direction.WEST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_l_ouest_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.WEST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    void avancer_vers_le_sud() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.SOUTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,2,Direction.SOUTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_le_sud_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.SOUTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

       
    @Test
    void init_tondeuse_e() throws ModelException, UtilsException{
        String entree = "1 2 E";
        Tondeuse expected = new Tondeuse(1,2, Direction.EAST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertEquals(expected, tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_w() throws ModelException, UtilsException{
        String entree = "1 2 W";
        Tondeuse expected = new Tondeuse(1,2, Direction.WEST);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertEquals(expected, tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_s() throws ModelException, UtilsException{
        String entree = "1 2 S";
        Tondeuse expected = new Tondeuse(1,2, Direction.SOUTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertEquals(expected, tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_n() throws ModelException, UtilsException{
        String entree = "1 2 N";
        Tondeuse expected = new Tondeuse(1,2, Direction.NORTH);
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertEquals(expected, tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_mauvaise_direction() throws ModelException, UtilsException{
        String entree = "1 2 T";
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_mauvaise_taille() throws ModelException, UtilsException{
        String entree = "1 2 E 2";
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_mauvaise_coordonnees_2() throws ModelException, UtilsException{
        String entree = "1 E E";
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree));
    }

    @Test
    void init_tondeuse_mauvaise_coordonnees_1() throws ModelException, UtilsException{
        String entree = "E 2 E";
        TondeuseUtils tondeuseUtils = new TondeuseUtils();

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree));
    }

}