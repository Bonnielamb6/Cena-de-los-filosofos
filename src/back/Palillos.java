/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class Palillos {
    boolean libre;
    int posicion;
    
    public Palillos(int p){
        libre = true;
        posicion = p;
    }

    public boolean isLibre() {
        return libre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
}
