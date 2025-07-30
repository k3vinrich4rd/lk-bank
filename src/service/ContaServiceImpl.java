package service;

public abstract class ContaServiceImpl implements ContaService {

    private int numeroConta;
    private String nomeTitular;
    private String CPF;
    private double saldo;

    @Override
    public double transferir(double valorTransferencia, ContaServiceImpl conta) {
        if (this.saldo <= 0 || this.saldo < valorTransferencia) {
            return 0;
            //Todo: Criar a task para criação de exeception
        }
        this.sacar(valorTransferencia);
        conta.depositar(valorTransferencia);
        return valorTransferencia;
    }
}