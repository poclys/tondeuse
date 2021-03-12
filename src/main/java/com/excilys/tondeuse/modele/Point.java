package com.excilys.tondeuse.modele;

import com.excilys.tondeuse.exception.ModelException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Point {

  private int x;
  private int y;

  public Point(final int x, final int y) throws ModelException {
    if (x < 0) {
      throw new ModelException(
        "La position selon l'axe Ouest-Est (x) ne peut pas être négative !"
      );
    }
    if (y < 0) {
      throw new ModelException(
        "La position selon l'axe Nord-Sud (y) ne peut pas être négative !"
      );
    }
    this.x = x;
    this.y = y;
  }

  public Point(final Point point) {
    this.x = point.getX();
    this.y = point.getY();
  }

  public int getX() {
    return x;
  }

  public void setX(final int x) throws ModelException {
    if (x < 0) {
      throw new ModelException(
        "La position selon l'axe Ouest-Est (x) ne peut pas être négative !"
      );
    }
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(final int y) throws ModelException {
    if (y < 0) {
      throw new ModelException(
        "La position selon l'axe Nord-Sud (y) ne peut pas être négative !"
      );
    }
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }

  @Override
  public boolean equals(final Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
