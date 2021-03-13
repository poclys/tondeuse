package com.excilys.tondeuse.modele;

import com.excilys.tondeuse.exception.modelexception.HauteurNegativeException;
import com.excilys.tondeuse.exception.modelexception.LongueurNegativeException;
import com.excilys.tondeuse.exception.modelexception.ModelException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Point {

  private int x;
  private int y;

  public Point(int x, int y) throws ModelException {
    if (x < 0) {
      throw new LongueurNegativeException();
    }
    if (y < 0) {
      throw new HauteurNegativeException();
    }
    this.x = x;
    this.y = y;
  }

  public Point(Point point) {
    this.x = point.getX();
    this.y = point.getY();
  }

  public int getX() {
    return x;
  }

  public void setX(int x) throws ModelException {
    if (x < 0) {
      throw new LongueurNegativeException();
    }
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) throws ModelException {
    if (y < 0) {
      throw new HauteurNegativeException();
    }
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
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
