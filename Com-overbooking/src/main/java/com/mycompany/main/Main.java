/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        
        System.out.println("=================================================");
        System.out.println("--- PROJETO 1: DEMONSTRAÇÃO DO OVERBOOKING (CAOS) ---");
        System.out.println("Assentos: 5 | Agentes: 7");
        System.out.println("=================================================");

        Onibus onibusCaotico = new Onibus();
        
        for (int i = 1; i <= 7; i++) {
            final int j = i; 
            new Thread(() -> onibusCaotico.reservarAssentoCaotico("Agente Caótico " + j)).start();
        }
        
        // Aguarda um tempo para todas as threads terminarem
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n*** RESULTADO FINAL (APÓS CONCORRÊNCIA) ***");
        System.out.println("Assentos restantes (Overbooking se negativo): " + onibusCaotico.getAssentosDisponiveis()); 
        System.out.println("-------------------------------------------------\n");
    }
}