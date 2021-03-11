package com.excilys.tondeuse.modele;

import java.util.ArrayList;
import java.util.List;

import com.excilys.tondeuse.exception.ModelException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Carte {

    private List<Tondeuse> tondeuses;
    private int longueur;
    private int hauteur;

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
        if (longueur < 0){
            throw new ModelException("la carte ne peut pas avoir une longueur negative !");
        }
        this.longueur = longueur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) throws ModelException {
        if ( hauteur < 0){
            throw new ModelException("la carte ne peut pas avoir une hauteur negative !");
        }
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        String result = longueur + " " + hauteur;
        for (Tondeuse tondeuse : tondeuses){
            result = result + " " + tondeuse;
        }
        return result;
    }

    public Carte(List<Tondeuse> tondeuses, int longueur, int hauteur) throws ModelException {
        if (longueur < 0){
            throw new ModelException("la carte ne peut pas avoir une longueur negative !");
        }
        if ( hauteur < 0){
            throw new ModelException("la carte ne peut pas avoir une hauteur negative !");
        }
        this.tondeuses = tondeuses;
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    public Carte() {
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public Carte(int longueur, int hauteur) {
        this.tondeuses = new ArrayList<>();
        this.longueur = longueur;
        this.hauteur = hauteur;
    }
    

}