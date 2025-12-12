/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author USER
 */
public class Onibus {
    private int assentosDisponiveis = 5; 

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void reservarAssentoWaitNotify(String agente) {
        // O bloco sincronizado garante que apenas uma thread acesse a seção crítica 
        synchronized (this) { 
            // Usa 'while' para verificar a condição após ser notificada
            while (assentosDisponiveis <= 0) {
                try {
                    // Se lotado, a thread entra em espera
                    System.out.println(agente + " - Ônibus lotado. Aguardando cancelamento...");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // A thread só chega aqui se houver assento (> 0) ou for notificada.
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            assentosDisponiveis--; 
            System.out.println(agente + " reservou. Restam: " + assentosDisponiveis);
        }
    }
    
    /**
     * Método de Cancelamento (O Produtor - Parte III).
     */
    public synchronized void cancelarPassagem(String agenteCancelador) {
        assentosDisponiveis++;
        System.out.println("\n" + agenteCancelador + " CANCELOU uma passagem! Vagas agora: " + assentosDisponiveis);
        // Avisa todas as threads em wait() que o estado mudou
        notifyAll(); // Deve ser chamado dentro do bloco sincronizado 
    }
}