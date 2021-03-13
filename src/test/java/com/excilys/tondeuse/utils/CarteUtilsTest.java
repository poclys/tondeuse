package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.excilys.tondeuse.exception.modelexception.ModelException;
import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CarteUtilsTest {

  @InjectMocks
  CarteUtils carteUtils;

  @Mock
  PointUtils pointUtils;

  @Test
  void init_carte() throws UtilsException, ModelException {
    String entree = "2 50";
    Carte expected = new Carte(2, 50);
    String[] forPointUtils = {"2","50"};
    when(pointUtils.stringToPoint(forPointUtils)).thenReturn(new Point(2,50));

    assertEquals(expected, carteUtils.initCarte(entree));
  }

  @Test
  void init_carte_trop_de_coordonnees() throws UtilsException {
    String entree = "2 5 4";

    assertThrows(UtilsException.class, () -> carteUtils.initCarte(entree));
  }

  @Test
  void init_carte_pas_assez_de_coordonnees() throws UtilsException {
    String entree = "2 ";

    assertThrows(UtilsException.class, () -> carteUtils.initCarte(entree));
  }

  @Test
  void init_carte_pas_de_coordonnees() throws UtilsException {
    String entree = "2 ze";

    String[] forPointUtils = {"2","ze"};
    when(pointUtils.stringToPoint(forPointUtils)).thenThrow(new UtilsException("erreur attendu"));

    assertThrows(UtilsException.class, () -> carteUtils.initCarte(entree));
  }
}
