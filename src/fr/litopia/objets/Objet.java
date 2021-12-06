/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.litopia.objets;

import java.util.ArrayList;
import fr.litopia.trajectoires.Coordonnée;

/**
 *
 * @author volatlo
 */
public abstract class Objet extends Boite {

    private static int nbreInstances = 0;
    private int numeroInstance;
    private Coordonnée pos;
    private Type type;

    public Objet(double largeur, double hauteur, double profondeur, Type type) {
        super(largeur, hauteur, profondeur);
        this.type = type;
        nbreInstances++;
        numeroInstance = nbreInstances;
    }

    public enum Type {
        Particule, ParticuleMarquée, Environnement
    }

    public static int getNbreInstances() {
        return nbreInstances;
    }

    public int getNumeroInstance() {
        return numeroInstance;
    }

    public Coordonnée getPos() {
        return pos;
    }

    public Type getType() {
        return type;
    }

    public void setPos(Coordonnée pos) {
        this.pos = pos;
    }

    public double getMinX() {
        return -getLargeur() / 2;
    }

    public double getMaxX() {
        return getLargeur() / 2;
    }

    public double getMinY() {
        return -getHauteur() / 2;
    }

    public double getMaxY() {
        return getHauteur() / 2;
    }

    public double getMinZ() {
        return -getProfondeur() / 2;
    }

    public double getMaxZ() {
        return getProfondeur() / 2;
    }

    public Coordonnée getCID() {
        return new Coordonnée(getMaxX(), getMinY(), getMaxZ());
    }

    public Coordonnée getCSG() {
        return new Coordonnée(getMinX(), getMaxY(), getMinZ());
    }

    public abstract void init(ArrayList<Objet> objs);

    public abstract void action(ArrayList<Objet> objs);

    public abstract void termine(ArrayList<Objet> objs);

    public abstract void affiche();

    public Boolean isIn(Coordonnée c) {
        Boolean in = false;
        if (c.getX() <= getMaxX() && c.getX() >= getMinX()
                && c.getY() <= getMaxY() && c.getY() >= getMinY()
                && c.getZ() <= getMaxZ() && c.getZ() >= getMinZ()) {
            in = true;
        }
        return in;
    }

    public String typeToString() {
        switch (type) {
            case Particule:
                return "Particule";
            case ParticuleMarquée:
                return "Particule marquée";
            case Environnement:
                return "Environnement";
        }
        return null;
    }

    @Override
    public String toString() {
        return "Objet_" + getNumeroInstance() + "(" + typeToString() + ")";
    }
}
