package com.excilys.tondeuse.modele;

public enum Direction {
  NORTH("N"),
  EAST("E"),
  SOUTH("S"),
  WEST("W");

  private String label;

  private Direction(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }
}
