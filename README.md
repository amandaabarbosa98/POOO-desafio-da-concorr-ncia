# Trabalho Prático: O Desafio da Concorrência na AMATUR

Disciplina: Programação Orientada a Objetos (Java) 
Professor: Jean Bertrand 
Tema: Domando o Caos com Threads e Sincronização

## 1. Relatório de Demonstração e Explicações
**1.1 Print do Console: Erro de overbooking**

Na fase inicial do projeto, demonstramos o cenário de caos onde ocorre o overbooking (venda de mais passagens do que assentos disponíveis).

<img width="470" height="355" alt="Image" src="https://github.com/user-attachments/assets/362ef9f3-43e7-4dd3-9749-6a039bdfd81b" />

**1.2 Como o synchronized resolveu a inconsistência?**

O uso da palavra-chave synchronized cria um Mutex. Ao aplicar o bloco sincronizado apenas na seção crítica (verificação e decremento do assento), garantimos que a operação seja atômica. Isso impede que dois agentes "leiam" o mesmo assento disponível ao mesmo tempo, eliminando as falhas de integridade nos dados.

**1.3 Como o wait/notify economiza CPU?**

Em vez de utilizar o busy-waiting (onde a thread fica rodando um loop infinito gastando processamento até que uma vaga surja), utilizamos os métodos wait() e notify(). 
- wait(): Coloca a thread do agente em estado de espera quando o ônibus está lotado, liberando os recursos da CPU para outras tarefas. 
- notify(): Quando ocorre um cancelamento, o sistema avisa as threads suspensas que uma nova vaga surgiu, permitindo que elas tentem realizar a reserva novamente de forma eficiente.
