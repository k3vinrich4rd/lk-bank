package service;

public class ContaTeste extends ContaServiceImpl {

    public ContaTeste(int numeroConta, String nomeTitular, String cPF, double saldo) {
        super(numeroConta, nomeTitular, cPF, saldo);
    }

    @Override
    public String toString() {
        return "Numero da conta: " + getNumeroConta() + "\nNome do titular: " + getNomeTitular() + "\nCpf: " + getCPF()
                + "\nSaldo: " + getSaldo();
    }

}
