import java.util.Random;
import java.util.Scanner;

import service.ContaServiceImpl;
import service.ContaTeste;

public class Application {
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
                    System.out.println("\nInsira o valor do depósito inicial: ");
                    double saldoInicial = sc.nextDouble();
                    Random random = new Random();
                    int numeroConta = random.nextInt(999999);
                    ContaServiceImpl conta = new ContaTeste(numeroConta, nomeTitular, CPF, saldoInicial);
                    System.out.println(conta);

                    x = 3;
                    break;
                case 2:
                    System.out.println("Função indisponível, tente novamente mais tarde!");

                default:
                    break;
            }
        }

        sc.close();

    }
}