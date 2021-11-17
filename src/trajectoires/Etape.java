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
    public Coordonnée pos1;
    public Coordonnée pos2;

    public Etape(Coordonnée pos1, Coordonnée pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }
    
    public double distance(){
        return  Math.sqrt(Math.pow((pos1.getX()-pos2.getX()),2)+Math.pow((pos1.getY()-pos2.getY()),2)+Math.pow((pos1.getZ()-pos2.getZ()),2));
    }

    @Override
    public String toString() {
        return pos1+"->"+pos2;
    }
}
