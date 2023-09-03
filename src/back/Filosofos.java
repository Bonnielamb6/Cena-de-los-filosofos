/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

/**
 *
 * @author PC
 */
public class Filosofos extends Thread{
    boolean comiendo;
    int tiempoEspera;
    Planificador buffer;
    
    
    public Filosofos(Planificador b, int t){
        comiendo = false;
        tiempoEspera = t;
        buffer = b;
    }
    
    
    public void comer(){
    
    }
    
    public void tomarIzquierda(){
    
    }
    
    public void tomarDerecha(){}
    
    public void empezarComer(){
        comiendo = true;
    }
    
    public void terminarComer(){
        comiendo = false;
    }
}
