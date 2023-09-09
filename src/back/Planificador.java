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
    
    
    
    public Planificador (int numPalillos){
        for(int i = 0;i< 5;i++){
            mesa[i] = new Palillos(i);
        }
        
    }
            
    
    public synchronized void tomarPalillos(int comensal){
        while(getPalillos(comensal, comensal) == 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Planificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tomarDerecha(comensal);
        tomarIzquierda(comensal);
        
        /*esto es por si acabo antes para hacerlo que pueda agarrar un palillo y despues el otro
        //determinar que palillos puede agarrar, regresa 2 si puede agarrar ambos, 1 solo el de la derecha,
        int opcion = getPalillos(comensal--,comensal);//-1 solo el de la izquierda, 0 ninguno(ambos estan tomados)
        if(opcion == 2){
            tomarDerecha(comensal);
            tomarIzquierda(comensal--);
            comensales[comensal].empezarComer();
            
        }else if(opcion == 1){
            tomarDerecha(comensal);
        }else if (opcion == -1){
            tomarIzquierda(comensal--);
        }
        */
        
        
    }
    
    public synchronized void dejarPalillos(int comensal){
        soltarDerecha(comensal);
        soltarIzquierda(comensal);
        notifyAll();
    }
    
    public void tomarIzquierda(int p){//que un filosofo tome su palillo de la izquierda
        if(p == 0){
            mesa[mesa.length-1].setLibre(false);
        }else{
            mesa[p-1].setLibre(false);
        }
        
    }
    
    public void tomarDerecha(int p){//que un filosofo tome su palillo de la derecha
        mesa[p].setLibre(false);
    }
    
    public void soltarDerecha(int p){
        mesa[p].setLibre(true);
    }
    
    public void soltarIzquierda(int p){
        if(p == 0){
            mesa[mesa.length-1].setLibre(true);
        }else{
            mesa[p-1].setLibre(true);
        }
    }
    
    public int getPalillos(int izq, int der){
        if(izq == 0){
            izq = mesa.length-1;
        }else {
            izq = izq -1;
        }
        if(mesa[izq].isLibre() && mesa [der].isLibre()){
            return 1;
        }else{
            return 0;
        }
        /*
        if(mesa[izq].isLibre() && mesa[der].isLibre()){         //ambos estan libres
            return 2;
        }else if(mesa[izq].isLibre()){              //solo esta libre el izquierdo    
            return -1;
        }else if (mesa[der].isLibre()){             //solo esta libre el derecho
            return 1;
        }else{                                      //ninguno esta libre
            return 0;
        }
        */
    }
    
    public int getIzquierdo(int i){
        if(i == 0){
            return mesa.length -1;
        }else{
            return i -1;
        }
        
    }
    
    public int getDerecho(int i){
        return i;
    }
}
