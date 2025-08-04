package service;

public interface ContaService {

    double sacar(double saldo);

    double depositar(double saldo);

    double transferir(double saldo, ContaServiceImpl conta);
}
