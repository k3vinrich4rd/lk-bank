package test;

import java.util.Scanner;

import service.ContaPoupanca;
import service.ContaServiceImpl;

public class ContaPoupancaTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo(a) ao LKBank!");
        System.out.println("Para começar, escolha: ");
        System.out.print("1 - Criar uma conta nova \n2 - Acessar uma conta existente \n3 - Fechar o programa: ");
        int x = sc.nextInt();
        sc.nextLine();
        while (x != 3) {
            switch (x) {
                case 1:
                    System.out.print("Para começar, insira o seu nome: ");
                    String nomeTitular = sc.nextLine();
                    System.out.print("\nAgora, seu CPF(Somente os números): ");
                    String CPF = sc.nextLine();
                    while (ContaServiceImpl.formatarCpf(CPF) == null) {
                        System.out.println("Número inválido! O CPF deve conter exatamente 11 caracteres.");
                        System.out.print("CPF (sem os pontos e linhas): ");
                        CPF = sc.nextLine();
                    }
                    System.out.println("\nInsira o valor do depósito inicial: ");
                    double saldoInicial = sc.nextDouble();
                    ContaServiceImpl conta = new ContaPoupanca(nomeTitular, CPF, saldoInicial);
                    System.out.println(conta.toString());
                    System.out.println("insira o valor do depósito: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println(conta.toString());

                    x = 3;
                    break;
                case 2:
                    System.out.println("Função indisponível, tente novamente mais tarde!");
                    x = 3;

                default:
                    break;
            }
        }

        sc.close();

    }
}