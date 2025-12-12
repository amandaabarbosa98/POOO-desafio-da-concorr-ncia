/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author USER
 */
public class Cancelamento implements Runnable {
    private Onibus onibus;
    
    public Cancelamento(Onibus onibus) {
        this.onibus = onibus;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(4000); 
            onibus.cancelarPassagem("Thread Cancelamento Automático");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}