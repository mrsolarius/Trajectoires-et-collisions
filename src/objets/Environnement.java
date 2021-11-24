/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

import java.util.ArrayList;

/**
 *
 * @author volatlo
 */
public class Environnement extends Objet {

    public Environnement(double largeur, double hauteur, double profondeur) {
        super(largeur, hauteur, profondeur, Objet.Type.Environnement);
    }

    @Override
    public void init(ArrayList<Objet> objs) {
    }

    @Override
    public void action(ArrayList<Objet> objs) {
    }

    @Override
    public void termine(ArrayList<Objet> objs) {
    }

    @Override
    public void affiche() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "[" + super.toString() + " :  " + getCID().toString() + ">" + getCSG().toString() + "]";
    }
}
