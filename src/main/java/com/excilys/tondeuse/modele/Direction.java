package com.excilys.tondeuse.modele;

public enum Direction {
  NORTH("N"),
  EAST("E"),
  WEST("W"),
  SOUTH("S");

  private String label;

  private Direction(final String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
