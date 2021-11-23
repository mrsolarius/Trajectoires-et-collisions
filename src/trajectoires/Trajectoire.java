/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trajectoires;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author volatlo
 */
public class Trajectoire {

    private List<Coordonnée> pos;

    public Trajectoire() {
        this.pos = new ArrayList<>();
    }

    public Boolean ajoute(Coordonnée pos) {
        return this.pos.add(pos);
    }

    public Boolean ajoute(Etape étape) {
        Boolean returnVal = false;
        if (this.pos.size() > 0) {
            Coordonnée pos = this.pos.get(this.pos.size());
            if (pos.equals(étape.getDépart())) {
                returnVal = this.ajoute(étape.getArrivée());
            }
        } else {
            returnVal = this.ajoute(étape.getDépart()) && this.ajoute(étape.getArrivée());
        }
        return returnVal;
    }

    public double distance() {
        double distance = 0;
        if (this.pos.size() >= 2) {
            for (int i = 0; i < pos.size() - 1; i++) {
                Etape e = new Etape(this.pos.get(i), this.pos.get(i + 1));
                distance += e.distance();
            }
        }
        return distance;
    }

    @Override
    public String toString() {
        String s = "";
        if (pos.size() == 0) {
            s += "Aucun point enregistré";
        } else if (pos.size() == 1) {
            s += "Il n'y a qu'un point enregistré : " + pos.get(0).toString();
        } else {
            Etape etape = new Etape(pos.get(0), pos.get(1));
            s += " [étape " + 1 + "] " + etape.toString();
            for (int i = 1; i < pos.size() - 1; i++) {
                s += " [étape " + (i + 1) + "] ";
                etape.set(pos.get(i), pos.get(i + 1));
                s += etape.toString();
            }
        }
        return s;
    }

}
