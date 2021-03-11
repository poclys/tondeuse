package com.excilys.tondeuse.modele;

public enum Direction {
    
    North("N"),East("E"),West("W"),South("S");

    private String label;

    private Direction(String label){
        this.label = label;
    }

    public String toString() {
        return this.label;
    }
}