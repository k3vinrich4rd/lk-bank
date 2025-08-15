package service;

public class ContaTeste extends ContaServiceImpl {

    public ContaTeste(String nomeTitular, String cPF, double saldo) {
        super(nomeTitular, cPF, saldo);
    }

    @Override
    public String toString() {
        return "Numero da conta: " + getNumeroConta() + "\nNome do titular: " + getNomeTitular() + "\nCpf: " + getCpf()
                + "\nSaldo: " + getSaldo();
    }

}
