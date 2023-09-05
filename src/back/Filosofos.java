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
    int tiempoEspera;
    int posicion;
    Planificador buffer;
    
    
    public Filosofos(Planificador b, int x, int t){
        comiendo = false;
        buffer = b;
        posicion = x;
        tiempoEspera = t;
        
    }

    @Override
    public void run() {
        
        while (true){
            try{
                
                if(buffer.getCantidadProductos()==0){
                    dormir();
                }else{
                    despertar();
                }
                if(despierto){
                    buffer.consumir();
                    System.out.println("Consumio");
                }
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public void empezarComer(){
        comiendo = true;
    }
    
    public void terminarComer(){
        comiendo = false;
    }
}
