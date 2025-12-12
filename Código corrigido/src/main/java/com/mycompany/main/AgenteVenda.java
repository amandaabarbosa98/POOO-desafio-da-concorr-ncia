/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author USER
 */
import java.util.concurrent.Semaphore;

public class AgenteVenda implements Runnable {
    private Onibus onibus;
    private Semaphore semaforo;
    private String nome;

    public AgenteVenda(Onibus onibus, Semaphore semaforo, String nome) {
        this.onibus = onibus;
        this.semaforo = semaforo;
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.println(nome + " aguardando permissão de conexão...");
        
        try {
            semaforo.acquire(); 
            
            System.out.println(nome + " CONECTOU. Permissões restantes: " + semaforo.availablePermits());
            
            // Tenta reservar usando a lógica de Wait/Notify
            onibus.reservarAssentoWaitNotify(nome);
            
            Thread.sleep(200); 
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Libera a permissão ao termina
            semaforo.release(); 
            System.out.println(nome + " DESCONECTOU. Permissões restantes: " + semaforo.availablePermits());
        }
    }
}
