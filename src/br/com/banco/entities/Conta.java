package br.com.banco.entities;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
//Conta.java
public abstract class Conta implements IConta {
 private static final int AGENCIA_PADRAO = 1;
 private static int SEQUENCIAL = 1;

 protected int agencia;
 protected int numero;
 protected double saldo;
 protected Cliente cliente; // Adicionado para associar a conta a um cliente

 public Conta(Cliente cliente) {
     this.agencia = Conta.AGENCIA_PADRAO;
     this.numero = SEQUENCIAL++;
     this.cliente = cliente;
 }

 @Override
 public void sacar(double valor) {
     if (valor > 0 && this.saldo >= valor) {
         this.saldo -= valor;
         System.out.println("Saque de R$" + valor + " realizado com sucesso.");
     } else if (valor <= 0) {
         System.out.println("O valor do saque deve ser positivo.");
     } else {
         System.out.println("Saldo insuficiente para realizar o saque.");
     }
 }

 @Override
 public void depositar(double valor) {
     if (valor > 0) {
         this.saldo += valor;
         System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
     } else {
         System.out.println("O valor do deposito deve ser positivo.");
     }
 }

 @Override
 public void transferir(double valor, Conta contaDestino) {
     if (valor > 0 && this.saldo >= valor) {
         this.sacar(valor);
         contaDestino.depositar(valor);
         System.out.println("Transferencia de R$" + valor + " para a conta " + contaDestino.getNumero() + " realizada com sucesso.");
     } else if (valor <= 0) {
         System.out.println("O valor da transferencia deve ser positivo.");
     } else {
         System.out.println("Saldo insuficiente para realizar a transferencia.");
     }
 }

 protected void imprimirInfosComuns() {
     System.out.println(String.format("Titular: %s", this.cliente.getNome()));
     System.out.println(String.format("Agencia: %d", this.agencia));
     System.out.println(String.format("Numero: %d", this.numero));
     System.out.println(String.format("Saldo: %.2f", this.saldo));
     System.out.println("Data/Hora da Operacao: " + LocalDateTime.now());
 }

}