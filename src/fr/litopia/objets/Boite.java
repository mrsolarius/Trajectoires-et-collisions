/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.litopia.objets;

/**
 *
 * @author volatlo
 */
public class Boite {
    private double largeur;
    private double hauteur;
    private double profondeur;

    public Boite(double largeur, double hauteur, double profondeur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.profondeur = profondeur;
    }

    public double getLargeur() {
        return largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getProfondeur() {
        return profondeur;
    }
    
}
