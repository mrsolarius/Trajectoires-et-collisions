/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

import java.util.ArrayList;
import java.util.Iterator;
import simulation.Random;
import trajectoires.Coordonnée;

/**
 *
 * @author volatlo
 */
public class Particule extends Objet {
    
    private Coordonnée vitesse;
    
    public Particule(double taille) {
        super(taille, taille, taille,Objet.Type.Particule);
        Random r = new Random(-1,1);
        vitesse = new Coordonnée(r.get(),r.get(),r.get());
    }

    public Boolean testePos(Coordonnée c, ArrayList<Objet> objList) {
        Boolean bonEmplacement = true;
        Iterator<Objet> iterator = objList.iterator();
        while (iterator.hasNext() && bonEmplacement) {
            Objet obj = iterator.next();
            if ((obj.isIn(c) && obj.getType() == Objet.Type.Particule) || (!obj.isIn(c) && obj.getType() == Objet.Type.Environnement)) {
                bonEmplacement = false;
            }
        }
        return bonEmplacement;
    }

    @Override
    public void init(ArrayList<Objet> objs) {
    }

    @Override
    public void action(ArrayList<Objet> objs) {
        Coordonnée c = new Coordonnée(getPos().getX()+vitesse.getX(),getPos().getY()+vitesse.getY(),vitesse.getZ()+getPos().getZ());
        if(testePos(c, objs)){
            this.setPos(c);
        }
        Random r = new Random(0.0,0.01);
        vitesse.set(
            vitesse.getX()+r.get(),
            vitesse.getY()+r.get(),
            vitesse.getZ()+r.get()
        );
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
        return "[" + super.toString() + ":" + getPos().toString() + "]";
    }
}
