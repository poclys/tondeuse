package com.excilys.tondeuse.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.excilys.tondeuse.exception.modelexception.ModelException;
import com.excilys.tondeuse.exception.utilsexception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Direction;
import com.excilys.tondeuse.modele.Point;
import com.excilys.tondeuse.modele.Tondeuse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IOUtilsTest {

  @InjectMocks
  IOUtils ioUtils;

  @Mock
  CarteUtils carteUtils;

  @Mock
  TondeuseUtils tondeuseUtils;

  @Test
  void read_file() throws IOException, UtilsException, ModelException {
    FileInputStream fis = new FileInputStream("src/test/resources/sample.txt");
    InputStream targetStream = fis;
    Carte initiale = new Carte(5,5);
    Carte expected = new Carte(5, 5);
    Tondeuse tondeuse1 = new Tondeuse(1, 2, Direction.WEST);
    expected.getTondeuses().add(tondeuse1);
    String initCarte = "5 5";
    String initTondeuse1 = "1 2 N";

    when(carteUtils.initCarte(initCarte)).thenReturn(new Carte(5, 5));
    when(tondeuseUtils.initTondeuse(initTondeuse1, initiale))
      .thenReturn(new Tondeuse(1, 2, Direction.NORTH));

    doAnswer(
        invocation -> {
          Object[] args = invocation.getArguments();
          ((Tondeuse) args[0]).setDirection(Direction.WEST);
          return null;
        }
      )
      .when(tondeuseUtils)
      .tournerAGauche(new Tondeuse(1, 2, Direction.NORTH));

    Carte result = ioUtils.readFile(targetStream);
    assertEquals(expected, result);
  }

  @Test
  void read_file_mauvaise_carte()
    throws IOException, UtilsException, ModelException {
    FileInputStream fis = new FileInputStream("src/test/resources/sample.txt");
    InputStream targetStream = fis;
    Carte expected = new Carte(5, 5);
    Tondeuse tondeuse1 = new Tondeuse(1, 2, Direction.WEST);
    expected.getTondeuses().add(tondeuse1);
    String initCarte = "5 5";
    when(carteUtils.initCarte(initCarte)).thenThrow(new UtilsException(""));

    assertThrows(UtilsException.class, () -> ioUtils.readFile(targetStream));
  }

  @Test
  void afficher_carte() throws ModelException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream orinalOut = System.out;
    System.setOut(new PrintStream(outContent));

    Carte carte = new Carte(3, 3);
    Tondeuse tondeuse1 = new Tondeuse(1, 2, Direction.WEST);
    carte.getTondeuses().add(tondeuse1);
    Tondeuse tondeuse2 = new Tondeuse(2, 0, Direction.NORTH);
    carte.getTondeuses().add(tondeuse2);

    ioUtils.afficherSortie(carte);
    assertEquals("1 2 W\n2 0 N\n", outContent.toString());

    System.setOut(orinalOut);
  }

  @Test
  void lecture_deplacement_a() throws ModelException, UtilsException {
    Tondeuse tondeuse = new Tondeuse(1, 2, Direction.NORTH);
    String line = "A";
    Carte carte = new Carte(4, 4);
    doAnswer(
        invocation -> {
          Object[] args = invocation.getArguments();
          ((Tondeuse) args[0]).setCoordonnees(new Point(1, 3));
          return null;
        }
      )
      .when(tondeuseUtils)
      .avancer(new Tondeuse(1, 2, Direction.NORTH), carte);
    Tondeuse expected = new Tondeuse(1, 3, Direction.NORTH);

    ioUtils.lectureDeplacement(line, tondeuse, carte);
    assertEquals(expected, tondeuse);
  }

  @Test
  void lecture_deplacement_a_impossible()
    throws ModelException, UtilsException {
    Tondeuse tondeuse = new Tondeuse(1, 2, Direction.NORTH);
    String line = "A";
    Carte carte = new Carte(2, 2);
    doThrow(new UtilsException("msg"))
      .when(tondeuseUtils)
      .avancer(new Tondeuse(1, 2, Direction.NORTH), carte);

    assertDoesNotThrow(() -> ioUtils.lectureDeplacement(line, tondeuse, carte));
  }

  @Test
  void lecture_deplacement_d()
    throws ModelException, UtilsException {
    Tondeuse tondeuse = new Tondeuse(1, 2, Direction.NORTH);
    String line = "D";
    Carte carte = new Carte(2, 2);
    doAnswer(
        invocation -> {
          Object[] args = invocation.getArguments();
          ((Tondeuse) args[0]).setDirection(Direction.EAST);
          return null;
        }
      )
      .when(tondeuseUtils)
      .tournerADroite(new Tondeuse(1, 2, Direction.NORTH));
    Tondeuse expected = new Tondeuse(1, 2, Direction.EAST);

    ioUtils.lectureDeplacement(line, tondeuse, carte);
    assertEquals(expected, tondeuse);
  }

  @Test
  void lecture_deplacement_autre()
    throws ModelException, UtilsException {
    Tondeuse tondeuse = new Tondeuse(1, 2, Direction.NORTH);
    String line = "Z";
    Carte carte = new Carte(2, 2);
    assertThrows(UtilsException.class,() -> ioUtils.lectureDeplacement(line, tondeuse, carte));
  }
}
