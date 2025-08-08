package service;

public interface ContaService {

    double sacar(double valorSaque);

    double depositar(double saldo);

    double transferir(double saldo, ContaService conta);
}
