package com.excilys.tondeuse.modele;

import com.excilys.tondeuse.exception.modelexception.HauteurNegativeException;
import com.excilys.tondeuse.exception.modelexception.LongueurNegativeException;
import com.excilys.tondeuse.exception.modelexception.ModelException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Carte {

  private List<Tondeuse> tondeuses;
  private int longueur;
  private int hauteur;

  public Carte(int longueur, int hauteur) throws ModelException {
    if (longueur < 0) {
      throw new LongueurNegativeException();
    }
    if (hauteur < 0) {
      throw new HauteurNegativeException();
    }
    this.tondeuses = new ArrayList<>();
    this.longueur = longueur;
    this.hauteur = hauteur;
  }

  public Carte(Point point) {
    this.tondeuses = new ArrayList<>();
    this.longueur = point.getX();
    this.hauteur = point.getY();
  }

  public List<Tondeuse> getTondeuses() {
    return tondeuses;
  }

  public void setTondeuses(List<Tondeuse> tondeuses) {
    this.tondeuses = tondeuses;
  }

  public int getLongueur() {
    return longueur;
  }

  public void setLongueur(int longueur) throws ModelException {
    if (longueur < 0) {
      throw new LongueurNegativeException();
    }
    this.longueur = longueur;
  }

  public int getHauteur() {
    return hauteur;
  }

  public void setHauteur(int hauteur) throws ModelException {
    if (hauteur < 0) {
      throw new HauteurNegativeException();
    }
    this.hauteur = hauteur;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(longueur);
    stringBuilder.append(" ").append(hauteur);
    for (Tondeuse tondeuse : tondeuses) {
      stringBuilder.append(" ").append(tondeuse);
    }
    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
