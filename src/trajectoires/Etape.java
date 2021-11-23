/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trajectoires;

/**
 *
 * @author volatlo
 */
public class Etape {
    private Coordonnée départ;
    private Coordonnée arrivée;

    public Etape(Coordonnée pos1, Coordonnée pos2) {
        set(pos1, pos2);
    }
    
    public double distance(){
        return  Math.sqrt(Math.pow((départ.getX()-arrivée.getX()),2)+Math.pow((départ.getY()-arrivée.getY()),2)+Math.pow((départ.getZ()-arrivée.getZ()),2));
    }

    public void set(Coordonnée pos1, Coordonnée pos2) {
        this.départ = pos1;
        this.arrivée = pos2;
    }

    public Coordonnée getDépart() {
        return départ;
    }

    public void setDépart(Coordonnée départ) {
        this.départ = départ;
    }

    public Coordonnée getArrivée() {
        return arrivée;
    }

    public void setArrivée(Coordonnée arrivée) {
        this.arrivée = arrivée;
    }    
    
    @Override
    public String toString() {
        return départ+"->"+arrivée;
    }
}
