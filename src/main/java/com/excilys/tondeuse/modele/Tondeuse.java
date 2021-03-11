package com.excilys.tondeuse.modele;

import com.excilys.tondeuse.exception.ModelException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Tondeuse {
    private Point coordonnees;
    private Direction direction;

    public Tondeuse(Point coordonnees, Direction direction) {
        this.coordonnees = coordonnees;
        this.direction = direction;
    }

    public Tondeuse(int x, int y, Direction direction) throws ModelException {

        this.coordonnees = new Point(x,y);
        this.direction = direction;
    }

    public Point getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Point coordonnees) throws ModelException {
        this.coordonnees = coordonnees;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return coordonnees.getX() + " " + coordonnees.getY() + " " + direction;
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