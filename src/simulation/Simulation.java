/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.util.ArrayList;
import objets.Environnement;
import objets.Objet;
import static objets.Objet.Type.Environnement;
import objets.Particule;
import objets.ParticuleSuivie;
import trajectoires.Coordonnée;

/**
 *
 * @author gladen
 */
public class Simulation {

    private final ArrayList<Objet> objList;
    private int iteration;

    
    public Simulation(double largeur, double hauteur, double profondeur) {
        objList = new ArrayList<>();
        Environnement env = new Environnement(largeur, hauteur, profondeur);
        objList.add(env);
    }

    
    public void init() {
        for (Objet obj : objList) {
            obj.init(objList);
        }
    iteration = 0;
    }

    public void action() {
        for (Objet obj : objList) {
            obj.action(objList);
        }
    iteration++;
    }

    public void termine() {
        for (Objet obj : objList) {
            obj.termine(objList);
        }
    }

    public void ajoute(Objet.Type type) {
        Particule p;
        switch (type) {
            case Particule:
                p = new Particule(1.0);
                break;
            case ParticuleMarquée:
                p = new ParticuleSuivie(1.0);
                break;
            default:
                return; // ce n'est pas une particule, on n'ajoute rien
        }
        Coordonnée c = new Coordonnée();
        Environnement env = (Environnement) objList.get(0);
        Random rX = new Random(env.getMinX(), env.getMaxX());
        Random rY = new Random(env.getMinY(), env.getMaxY());
        Random rZ = new Random(env.getMinZ(), env.getMaxZ());
        Boolean ok = false;
        do {
            c.set(rX.get(), rY.get(), rZ.get());
            ok = p.testePos(c, objList);
        } while (!ok);
        p.setPos(c);
        objList.add(p);
    }

    @Override
    public String toString() {
        String s = "Simulation à l'itération #"+iteration+" : \n";
        for (Objet obj : objList) {
            s += obj.toString() + " ";
        }
        return s;
    }

    public void affiche() {
        System.out.println("Simulation à l'itération #"+iteration+" : ");
        for (Objet obj : objList) {
            obj.affiche();
        }
    }
}
