package service;

public interface ContaService {

    double sacar(double saldo, ContaServiceImpl conta);

    double depositar(double saldo, ContaServiceImpl conta);

    double transferir(double saldo, ContaServiceImpl conta);
}
