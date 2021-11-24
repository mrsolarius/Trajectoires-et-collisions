/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets.Objet;
import org.xml.sax.SAXException;
import trajectoires.Coordonnée;
import trajectoires.Etape;
import trajectoires.Trajectoire;

/**
 *
 * @author volatlo
 */
public class Main {

    public static void main(String[] args) {
        Coordonnée pos1;

        // 2. instanciation utilisant le constructeur par défaut
        pos1 = new Coordonnée(0, 0, 0);
        Coordonnée pos2 = new Coordonnée(1, 1, 0);

        // 3. remplissage : initialisation de la première Coordonnée avec les valeurs (0.1,0.0,-1.0)
        pos1.set(0.1, 0.0, -1.0);

        // --
        // -- Création d'une deuxième Coordonnée pos2
        // --
        // 1. déclaration
        //... ajouter code...
        //Coordonnée pos2;
        // 2. instanciation utilisant le constructeur qui initialise la Coordonnée avec les valeurs (1.0, 1.0, 0.01)
        //... ajouter code...
        pos2 = new Coordonnée(1.0, 1.0, 0.01);

        // 3. modification : re-initialisation de la deuxième Coordonnée avec les valeurs (1.0, 1.0, 0.0)
        //... ajouter code...
        pos2.setZ(0.0);

        // affichage des deux coordonnées dans la fenêtre de résultats
        System.out.println("Coordonnée 1 : " + pos1 + " Coordonée 2 : " + pos2);

        Etape e = new Etape(pos1, pos2);

        System.out.println(e);

        System.out.println("LA distance :" + e.distance());

        Trajectoire trajectoire = new Trajectoire();
        try {
            trajectoire.readDOM("src/xml/", "trajectoire.xml");
        } catch (SAXException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(trajectoire.toString());
        System.out.println("\nDistance parcourue sur toute la trajectoire : " + trajectoire.distance());

        Simulation simu = new Simulation(100, 100, 100);
        simu.ajoute(Objet.Type.Particule);
        simu.ajoute(Objet.Type.Particule);
        simu.ajoute(Objet.Type.ParticuleMarquée);

        simu.init();
        simu.affiche();

        for (int i = 0; i < 10; i++) {
            simu.action();
            simu.affiche();
        }

        simu.termine();
    }
}
