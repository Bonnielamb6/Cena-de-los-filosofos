/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Filosofos extends Thread{
    boolean comiendo;
    int posicion;
    Planificador buffer;
    boolean corriendo;
    
    public Filosofos(Planificador b, int x){
        comiendo = false;
        buffer = b;
        posicion = x;
        corriendo = false;
    }

    @Override
    public void run() {
        
        while (true){
            pensar();
            buffer.tomarPalillos(posicion);
            empezarComer();
            System.out.println("Filosofo " + posicion + " deja palillos: "+buffer.getIzquierdo(posicion) + " y "+buffer.getDerecho(posicion));
            buffer.dejarPalillos(posicion);
            terminarComer();
            pensar();
            /*
            try{
                if(!comiendo){
                    buffer.filosofosLibres(); // o comer, no se cual xd
                    System.out.println("Filosofo "+posicion +"comiendo");
                }
                sleep(tiempoEspera);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }
    }
    
    
    
    public void empezarComer(){
        comiendo = true;
        System.out.println("Filosofo "+ posicion + " comiendo");
        try {
            sleep((long) (Math.random() * 15000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarComer(){
        comiendo = false;
    }
    
    public void pensar(){
        System.out.println("Filosofo "+posicion + " pensando");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean getEstado(){
        return comiendo;
    }
    
    public void detener(){
        corriendo = false;
    }
    
    public void iniciar(){
        corriendo = true;
    }
    public boolean isCorriendo(){
        return corriendo;
    }
}
