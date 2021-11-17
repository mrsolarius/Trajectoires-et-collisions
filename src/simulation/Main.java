/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import trajectoires.Coordonnée;
import trajectoires.Etape;

/**
 *
 * @author volatlo
 */
public class Main {
    
    public static void main(String[] args){
        Coordonnée pos1;         

        // 2. instanciation utilisant le constructeur par défaut
        pos1 = new Coordonnée();

        // 3. remplissage : initialisation de la première Coordonnée avec les valeurs (0.1,0.0,-1.0)
        pos1.set(0.1, 0.0, -1.0);

        // --
        // -- Création d'une deuxième Coordonnée pos2
        // --

        // 1. déclaration
        //... ajouter code...
        Coordonnée pos2;
        
        // 2. instanciation utilisant le constructeur qui initialise la Coordonnée avec les valeurs (1.0, 1.0, 0.01)
        //... ajouter code...
        pos2 = new Coordonnée(1.0, 1.0, 0.01);
        
        // 3. modification : re-initialisation de la deuxième Coordonnée avec les valeurs (1.0, 1.0, 0.0)
        //... ajouter code...
        pos2.setZ(0.0);

        // affichage des deux coordonnées dans la fenêtre de résultats
        System.out.println("Coordonnée 1 : " + pos1 +" Coordonée 2 : "+pos2);
        
        Etape e = new Etape(pos1,pos2);
        
        System.out.println(e);
        
        System.out.println("LA distance :"+e.distance());
    }
}
