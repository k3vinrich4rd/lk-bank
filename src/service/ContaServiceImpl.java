package service;

public abstract class ContaServiceImpl implements ContaService {

    private int numeroConta;
    private String nomeTitular;
    private String CPF;
    private double saldo;

    public double sacar(double valorSaque){
        if (this.saldo <= 0 || this.saldo < valorSaque){
            return 0;
        }
        return this.saldo - valorSaque;
    }

    public double depositar(double valorDeposito){
        return this.saldo + valorDeposito;
    }

    @Override
    public double transferir(double valorTransferencia, ContaServiceImpl conta) {
        if (this.saldo <= 0 || this.saldo < valorTransferencia) {
            return 0;
            //Todo: Criar a task para criação de exception
        }
        this.sacar(valorTransferencia);
        conta.depositar(valorTransferencia);
        return valorTransferencia;
    }
}