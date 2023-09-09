/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import back.Planificador;
import back.Filosofos;
import back.Palillos;

/**
 *
 * @author User
 */
public class main {
    public static void main(String[] args) {
        Planificador programa = new Planificador(5);
        for (int i = 0;i<5;i++){
            Filosofos temp = new Filosofos(programa,i);
            temp.start();
        }
    }
}
