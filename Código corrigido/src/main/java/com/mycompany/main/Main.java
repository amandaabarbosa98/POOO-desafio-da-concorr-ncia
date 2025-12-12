/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author USER
 */
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("==================================================================");
        System.out.println("--- PROJETO 2: SOLUÇÃO COM SEMÁFORO, SYNCHRONIZED E WAIT/NOTIFY ---");
        System.out.println("Assentos: 5 | Conexões Simultâneas: 3 | Agentes: 7");
        System.out.println("==================================================================");

        Onibus onibusSeguro = new Onibus();
        
        // Inicializa o semáforo com 3 permissões 
        Semaphore semaforoConexoes = new Semaphore(3); 
        
        // Inicia a thread de cancelamento
        Thread cancelamento = new Thread(new Cancelamento(onibusSeguro));
        cancelamento.start();
        
        // Cria 7 agentes 
        for (int i = 1; i <= 7; i++) {
            final int j = i; 
            Thread agente = new Thread(new AgenteVenda(onibusSeguro, semaforoConexoes, "Agente Seguro " + j));
            agente.start();
        }
        
        try {
            Thread.sleep(6000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n*** RESULTADO FINAL (APÓS SOLUÇÃO) ***");
        System.out.println("Assentos restantes após reservas e cancelamento: " + onibusSeguro.getAssentosDisponiveis()); 
        System.out.println("------------------------------------------------------------------\n");
    }
}