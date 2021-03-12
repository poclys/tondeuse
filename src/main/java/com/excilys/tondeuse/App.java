package com.excilys.tondeuse;

import com.excilys.tondeuse.exception.UtilsException;
import com.excilys.tondeuse.modele.Carte;
import com.excilys.tondeuse.modele.Tondeuse;
import com.excilys.tondeuse.utils.CarteUtils;
import com.excilys.tondeuse.utils.IOUtils;
import com.excilys.tondeuse.utils.TondeuseUtils;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) throws UtilsException {
    CarteUtils carteUtils = new CarteUtils();
    IOUtils ioUtils = new IOUtils();
    TondeuseUtils tondeuseUtils = new TondeuseUtils();

    Carte carte = carteUtils.initCarte("5 5");

    Tondeuse tondeuse1 = tondeuseUtils.initTondeuse("1 2 N");
    ioUtils.lectureDeplacement("GAGAGAGAA", tondeuse1, carte);
    carte.getTondeuses().add(tondeuse1);
    Tondeuse tondeuse2 = tondeuseUtils.initTondeuse("3 3 E");
    ioUtils.lectureDeplacement("AADAADADDAAAAAAAAA", tondeuse2, carte);
    carte.getTondeuses().add(tondeuse2);

    ioUtils.afficherSortie(carte);
  }
}
