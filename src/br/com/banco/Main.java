package br.com.banco;

import br.com.banco.entities.Banco;
import br.com.banco.entities.Cliente;
import br.com.banco.entities.Conta;
import br.com.banco.entities.ContaCorrente;
import br.com.banco.entities.ContaPoupanca;

//Main.java
public class Main {
 
	public static void main(String[] args) {
     // Criando um banco
	 Banco meuBanco = new Banco(); 
     meuBanco.setNome("Meu Banco Digital");
     System.out.println("Bem-vindo ao " + meuBanco.getNome());
     System.out.println("---");

     // Criando clientes
     Cliente venilton = new Cliente();
     venilton.setNome("Venilton");

     Cliente camila = new Cliente();
     camila.setNome("Camila");

     // Criando contas
     Conta cc = new ContaCorrente(venilton);
     Conta cp = new ContaPoupanca(venilton);
     Conta poupanca = new ContaPoupanca(camila);

     // Realizando operações
     cc.depositar(1000);
     cc.sacar(200);
     cc.transferir(150, poupanca);
     cp.transferir(10, cp);
     
     cp.depositar(1800);
     cp.sacar(22);

     poupanca.depositar(50); // Camila também pode depositar na conta dela

     // Imprimindo extratos
     cc.imprimirExtrato();
     System.out.println("---");
     cp.imprimirExtrato();
     System.out.println("---");
     poupanca.imprimirExtrato();
     System.out.println("---");

     // Tentando operações com saldo insuficiente ou valor inválido
     cc.sacar(10000); // Saldo insuficiente
     cc.depositar(-50); // Valor inválido
     cc.transferir(-10, poupanca); // Valor inválido
 }

}
