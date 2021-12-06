/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.litopia.objets;

import java.util.ArrayList;
import fr.litopia.trajectoires.Trajectoire;

/**
 *
 * @author volatlo
 */
public class ParticuleSuivie extends Particule {
    private Trajectoire trajectoire;

    public ParticuleSuivie(double taille) {
        super(taille);
    }

    @Override
    public void init(ArrayList<Objet> objs) {
        trajectoire = new Trajectoire();
        trajectoire.ajoute(getPos());
    }

    @Override
    public void action(ArrayList<Objet> objs) {
        super.action(objs);
        trajectoire.ajoute(getPos());
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Trajectoire : " +trajectoire.toString();
    }
    
}
