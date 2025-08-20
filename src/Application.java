import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import service.ContaPoupanca;
import service.ContaServiceImpl;
import service.FileService;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileService f = new FileService();
        File pasta = new File("\\LKBANK\\accounts\\");

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
                    String cpf = sc.nextLine();

                    while (ContaServiceImpl.formatarCpf(cpf) == null) {
                        System.out.println("Número inválido! O CPF deve conter exatamente 11 caracteres.");
                        System.out.print("\nAgora, seu CPF(Somente os números): ");
                        cpf = sc.nextLine();
                    }
                    System.out.println("\nInsira o valor do depósito inicial: ");
                    double saldoInicial = sc.nextDouble();
                    ContaServiceImpl conta = new ContaPoupanca(nomeTitular, cpf, saldoInicial);
                    if (!pasta.exists()) {
                        pasta.mkdirs();
                    }
                    try (BufferedWriter bx = new BufferedWriter(
                            new FileWriter("\\LKBANK\\accounts\\" + conta.getNumeroConta() + ".txt"))) {
                        bx.write(conta.fileWriter(conta));
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    System.out.println("Conta criada com sucesso! " + conta);

                    System.out.println("Insira o valor do depósito: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println(conta.toString());

                    x = 3;
                    break;
                case 2:
                    System.out.println("Insira o número da sua conta: ");
                    int numeroC = sc.nextInt();

                    while (f.pesquisa(numeroC) == null) {

                        System.out.println("Conta não encontrada! \nInsira o número da sua conta: ");
                        numeroC = sc.nextInt();
                    }
                    // Pesquisa a conta pelo número e instancia ela baseada no retorno da classe
                    // FileUtil

                    ContaServiceImpl resultado = new ContaPoupanca(f.pesquisa(numeroC).getNumeroConta(),
                            f.pesquisa(numeroC).getNomeTitular(),
                            f.pesquisa(numeroC).getCpfF(),
                            f.pesquisa(numeroC).getSaldo());
                    System.out.println(resultado.toString());
                     
                               
                    System.out.println("Bem vindo(a) " + resultado.getNomeTitular() + "! O que deseja fazer com a sua conta?");
                    System.out.print("1 - Depósito\n2 - Saque\n3 - Transferência: ");
                    int y = sc.nextInt();
                    while (y != 0) {
                        switch (y) {
                            case 1:
                                System.out.print("Insira o valor do depósito: ");
                                double deposito = sc.nextDouble();
                                resultado.depositar(deposito);
                                System.out.print("Depósito realizado com sucesso! \nNovo saldo: " + resultado.getSaldo());
                                       try (BufferedWriter bx = new BufferedWriter(new FileWriter("\\LKBANK\\accounts\\" + resultado.getNumeroConta() + ".txt"))) {
                                    bx.write(resultado.fileWriter(resultado));
                                } catch (IOException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                                y=0;
                                x=3;
                                break;
                            case 2:
                            System.out.println("Insira o valor do saque: ");
                            double saque = sc.nextDouble();
                            resultado.sacar(saque);
                            System.out.println("Saque realizado com sucesso! \nNovo saldo: " + resultado.getSaldo());
                                    try (BufferedWriter bx = new BufferedWriter(new FileWriter("\\LKBANK\\accounts\\" + resultado.getNumeroConta() + ".txt"))) {
                                    bx.write(resultado.fileWriter(resultado));
                                } catch (IOException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            y=0;
                            x=3;
                            break;
                            case 3:
                            System.out.println("Insira o valor da transferência: ");
                            double transferencia = sc.nextDouble();
                            System.out.println("Insira o número da conta que vai receber a transferência: ");
                            int contaAlvo = sc.nextInt();

                            while(f.pesquisa(contaAlvo) == null){
                                System.out.println("Conta não encontrada! \nInsira o número da sua conta: ");
                                contaAlvo = sc.nextInt();
                            }
                            ContaServiceImpl receptor = new ContaPoupanca(f.pesquisa(contaAlvo).getNumeroConta(),
                                f.pesquisa(contaAlvo).getNomeTitular(),
                                f.pesquisa(contaAlvo).getCpfF(),
                                f.pesquisa(contaAlvo).getSaldo());
                            resultado.transferir(transferencia, receptor);
                            System.out.println("Transferência concluída com sucesso!\nSaldo conta remetente: " + resultado.getSaldo() + "\nSaldo conta destinatária: " + receptor.getSaldo());
                                    try (BufferedWriter bx = new BufferedWriter(new FileWriter("\\LKBANK\\accounts\\" + resultado.getNumeroConta() + ".txt"));
                                          BufferedWriter rx = new BufferedWriter(new FileWriter("\\LKBANK\\accounts\\" + receptor.getNumeroConta() + ".txt"))) {
                                    bx.write(resultado.fileWriter(resultado));
                                    rx.write(receptor.fileWriter(receptor));
                                } catch (IOException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                                y=0;
                                x=3;


                        
                            default:    
                        
                                break;
                            }
                        
                    }
                
                                 
                    

                    continue;

                default:
                    break;
        }
        }sc.close();

}}

