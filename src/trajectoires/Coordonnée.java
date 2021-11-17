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
public class Coordonnée {

    private double x;
    private double y;
    private double z;

    public Coordonnée() {
        this.set(0.0, 0.0, 0.0);
    }

    public Coordonnée(double x, double y, double z) {
        this.set(x, y, z);
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Boolean isEqual(Coordonnée pos) {
        return ((pos.x == x) && (pos.y == y) && (pos.z == z));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
