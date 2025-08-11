package service;

public class ContaPoupanca extends ContaServiceImpl {

    public ContaPoupanca(String nomeTitular, String cPF, double saldo) {
        super(nomeTitular, cPF, saldo);
    }

    @Override
    public double depositar(double saldo) {
        return super.depositar(saldo + (saldo * 0.02));
    }
 @Override
    public String toString() {
        return "Numero da conta: " + getNumeroConta() + "\nNome do titular: " + getNomeTitular() + "\nCpf: " + getCPF()
                + "\nSaldo: " + getSaldo();
    }
}
