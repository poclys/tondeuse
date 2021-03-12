package com.excilys.tondeuse.modele;

import com.excilys.tondeuse.exception.ModelException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Carte {

  private List<Tondeuse> tondeuses;
  private int longueur;
  private int hauteur;
  private static final String LONGUEUR_NEGATIVE =
    "la carte ne peut pas avoir une longueur negative !";
  private static final String HAUTEUR_NEGATIVE =
    "la carte ne peut pas avoir une hauteur negative !";

  public List<Tondeuse> getTondeuses() {
    return tondeuses;
  }

  public void setTondeuses(final List<Tondeuse> tondeuses) {
    this.tondeuses = tondeuses;
  }

  public int getLongueur() {
    return longueur;
  }

  public void setLongueur(final int longueur) throws ModelException {
    if (longueur < 0) {
      throw new ModelException(LONGUEUR_NEGATIVE);
    }
    this.longueur = longueur;
  }

  public int getHauteur() {
    return hauteur;
  }

  public void setHauteur(final int hauteur) throws ModelException {
    if (hauteur < 0) {
      throw new ModelException(HAUTEUR_NEGATIVE);
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

  public Carte(
    final List<Tondeuse> tondeuses,
    final int longueur,
    final int hauteur
  )
    throws ModelException {
    if (longueur < 0) {
      throw new ModelException(LONGUEUR_NEGATIVE);
    }
    if (hauteur < 0) {
      throw new ModelException(HAUTEUR_NEGATIVE);
    }
    this.tondeuses = tondeuses;
    this.longueur = longueur;
    this.hauteur = hauteur;
  }

  @Override
  public boolean equals(final Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  public Carte(final int longueur, final int hauteur) throws ModelException {
    if (longueur < 0) {
      throw new ModelException(LONGUEUR_NEGATIVE);
    }
    if (hauteur < 0) {
      throw new ModelException(HAUTEUR_NEGATIVE);
    }
    this.tondeuses = new ArrayList<>();
    this.longueur = longueur;
    this.hauteur = hauteur;
  }

  public Carte(final Point point) {
    this.tondeuses = new ArrayList<>();
    this.longueur = point.getX();
    this.hauteur = point.getY();
  }
}
