package service;

public class ContaCorrente extends ContaServiceImpl {

    public ContaCorrente(String nomeTitular, String cPF, double saldo) {
        super(nomeTitular, cPF, saldo);
    }

    @Override
    public double sacar(double valorSaque) {
        double taxa = 0.05 * valorSaque;
        double valorTotal = valorSaque + taxa;
        return super.sacar(valorTotal);
    }
}



