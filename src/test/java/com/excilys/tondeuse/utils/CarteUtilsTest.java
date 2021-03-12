package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.excilys.tondeuse.exception.ModelException;
import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;

import org.junit.jupiter.api.Test;

class CarteUtilsTest {
    @Test
    void init_carte() throws UtilsException, ModelException{
        String entree = "2 50";
        Carte expected = new Carte(2,50);
        CarteUtils carteUtils = new CarteUtils();

        assertEquals(expected, carteUtils.initCarte(entree));
    }

    @Test
    void init_carte_trop_de_coordonnees() throws UtilsException {
        String entree = "2 5 4";
        CarteUtils carteUtils = new CarteUtils();

        assertThrows(UtilsException.class,() -> carteUtils.initCarte(entree));
    }

    @Test
    void init_carte_pas_assez_de_coordonnees() throws UtilsException {
        String entree = "2 ";
        CarteUtils carteUtils = new CarteUtils();

        assertThrows(UtilsException.class,() -> carteUtils.initCarte(entree));
    }

    @Test
    void init_carte_pas_de_coordonnees() throws UtilsException {
        String entree = "2 ze";
        CarteUtils carteUtils = new CarteUtils();

        assertThrows(UtilsException.class,() -> carteUtils.initCarte(entree));
    }

}
