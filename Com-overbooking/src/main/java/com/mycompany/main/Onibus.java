/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author USER
 */
// Onibus.java (Projeto 1 - Caótico)
public class Onibus {
    private int assentosDisponiveis = 5; 
    public void reservarAssentoCaotico(String agente) {
        if (assentosDisponiveis > 0) { // Verificação da vaga 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Decrementa o assento (seção crítica) 
            assentosDisponiveis--; 
            System.out.println(agente + " reservou um assento. Restam: " + assentosDisponiveis);
        } else {
            System.out.println(agente + " falhou: Ônibus lotado!");
        }
    }
    
    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }
}