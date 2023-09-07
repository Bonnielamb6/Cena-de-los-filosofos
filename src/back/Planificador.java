/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Planificador {
    Palillos mesa [] = new Palillos [5];
    Filosofos comensales[] = new Filosofos[5];
    
    
    public Planificador (int t1,int t2, int t3, int t4, int t5){
        for(int i = 0;i< 5;i++){
            mesa[i] = new Palillos(i);
        }
        comensales[0] = new Filosofos(this, 1, t1);
        comensales[1] = new Filosofos(this, 2, t2);
        comensales[2] = new Filosofos(this, 3, t3);
        comensales[3] = new Filosofos(this, 4, t4);
        comensales[4] = new Filosofos(this, 5, t5);
    }
            
    public void filosofosLibres(){//conseguir los filosofo que tienen palillos libres a los lados para empezar a comer
        while(true){
            for(int i = 0;i < comensales.length;i++){
                comer(i);
            }
        }
    }
    
    public synchronized void comer(int i){
        
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Planificador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //determinar que palillos puede agarrar, regresa 2 si puede agarrar ambos, 1 solo el de la derecha,
        int opcion = getPalillos(i--,i);//-1 solo el de la izquierda, 0 ninguno(ambos estan tomados)
        if(opcion == 2){
            tomarDerecha(i);
            tomarIzquierda(i--);
            comensales[i].empezarComer();
            
        }else if(opcion == 1){
            tomarDerecha(i);
        }else if (opcion == -1){
            tomarIzquierda(i--);
        }
        
        comensales[i].terminarComer();
        notifyAll();
    }
    
    public void tomarIzquierda(int p){//que un filosofo tome su palillo de la izquierda
        mesa[p].setLibre(false);
    }
    
    public void tomarDerecha(int p){//que un filosofo tome su palillo de la derecha
        mesa[p].setLibre(false);
    }
    
    public void soltarDerecha(int p){
        mesa[p].setLibre(true);
    }
    
    public void soltarIzquierda(int p){
        mesa[p].setLibre(true);
    }
    
    public int getPalillos(int izq, int der){
        if(izq <0){
            izq = mesa.length-1;
        }
        if(mesa[izq].isLibre() && mesa[der].isLibre()){
            return 2;
        }else if(mesa[izq].isLibre()){
            return -1;
        }else if (mesa[der].isLibre()){
            return 1;
        }else{
            return 0;
        }
    }
}
