package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.excilys.tondeuse.exception.modelexception.ModelException;
import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Point;
import com.excilys.tondeuse.modele.Tondeuse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TondeuseUtilsTest {

    @InjectMocks
    TondeuseUtils tondeuseUtils;

    @Mock
    PointUtils pointUtils;

    @Mock
    DirectionUtils directionUtils;



    @Test
    void tourner_a_gauche_north() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.NORTH);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.WEST);

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_gauche_west() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.WEST);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.SOUTH);

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_gauche_south() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.SOUTH);
        Tondeuse tondeuseExpected = new Tondeuse(0, 0, Direction.EAST);

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_gauche_east() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.EAST);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.NORTH);

        tondeuseUtils.tournerAGauche(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }



    @Test
    void tourner_a_droite_north() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.NORTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.EAST);

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_droite_west() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.WEST);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.NORTH);

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_droite_south() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.SOUTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.WEST);

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void tourner_a_droite_east() throws ModelException {
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.EAST);
        Tondeuse tondeuseExpected = new Tondeuse(0,0,Direction.SOUTH);

        tondeuseUtils.tournerADroite(tondeuseEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_l_est() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.EAST);
        Tondeuse tondeuseExpected = new Tondeuse(1,0,Direction.EAST);

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_l_est_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.EAST);

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    void avancer_vers_le_nord() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 0, Direction.NORTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,1,Direction.NORTH);

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_le_nord_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.NORTH);
        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    void avancer_vers_l_ouest() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.WEST);
        Tondeuse tondeuseExpected = new Tondeuse(2,0,Direction.WEST);

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_l_ouest_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.WEST);

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

    @Test
    void avancer_vers_le_sud() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(0, 3, Direction.SOUTH);
        Tondeuse tondeuseExpected = new Tondeuse(0,2,Direction.SOUTH);

        tondeuseUtils.avancer(tondeuseEntree, carteEntree);
        assertEquals(tondeuseExpected, tondeuseEntree);
    }

    @Test
    void avancer_vers_le_sud_doit_echouer() throws UtilsException, ModelException {
        Carte carteEntree = new Carte(3,3);
        Tondeuse tondeuseEntree = new Tondeuse(3, 0, Direction.SOUTH);

        assertThrows(UtilsException.class,() -> tondeuseUtils.avancer(tondeuseEntree, carteEntree));
    }

       
    @Test
    void init_tondeuse_e() throws ModelException, UtilsException{
        String entree = "1 2 E";
        Tondeuse expected = new Tondeuse(1,2, Direction.EAST);
        String[] forPointUtils = {"1","2","E"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenReturn(new Point(1,2));
        when(directionUtils.stringToDirection("E")).thenReturn(Direction.EAST);

        assertEquals(expected, tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_w() throws ModelException, UtilsException{
        String entree = "1 2 W";
        Tondeuse expected = new Tondeuse(1,2, Direction.WEST);
        String[] forPointUtils = {"1","2","W"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenReturn(new Point(1,2));
        when(directionUtils.stringToDirection("W")).thenReturn(Direction.WEST);

        assertEquals(expected, tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_s() throws ModelException, UtilsException{
        String entree = "1 2 S";
        Tondeuse expected = new Tondeuse(1,2, Direction.SOUTH);
        String[] forPointUtils = {"1","2","S"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenReturn(new Point(1,2));
        when(directionUtils.stringToDirection("S")).thenReturn(Direction.SOUTH);

        assertEquals(expected, tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_n() throws ModelException, UtilsException{
        String entree = "1 2 N";
        Tondeuse expected = new Tondeuse(1,2, Direction.NORTH);
        String[] forPointUtils = {"1","2","N"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenReturn(new Point(1,2));
        when(directionUtils.stringToDirection("N")).thenReturn(Direction.NORTH);

        assertEquals(expected, tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_mauvaise_direction() throws ModelException, UtilsException{
        String entree = "1 2 T";
        String[] forPointUtils = {"1","2","T"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenReturn(new Point(1,2));
        when(directionUtils.stringToDirection("T")).thenThrow(new UtilsException("msg"));

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_mauvaise_taille() throws ModelException, UtilsException{
        String entree = "1 2 E 2";
        Carte carte = new Carte(5,5);

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_mauvaise_coordonnees_2() throws ModelException, UtilsException{
        String entree = "1 E E";
        String[] forPointUtils = {"1","E","E"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenThrow(new UtilsException("msg"));

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree, carte));
    }

    @Test
    void init_tondeuse_mauvaise_coordonnees_1() throws ModelException, UtilsException{
        String entree = "E 2 E";
        String[] forPointUtils = {"E","2","E"};
        Carte carte = new Carte(5,5);

        when(pointUtils.stringToPoint(forPointUtils)).thenThrow(new UtilsException("msg"));

        assertThrows(UtilsException.class,() -> tondeuseUtils.initTondeuse(entree, carte));
    }

}