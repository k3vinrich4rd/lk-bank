package service;

public abstract class ContaServiceImpl implements ContaService {

    private int numeroConta;
    private String nomeTitular;
    private String CPF;

    public ContaServiceImpl(int numeroConta, String nomeTitular, String cPF, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        CPF = cPF;
        this.saldo = saldo;
    }

    private double saldo;

    public double sacar(double valorSaque) {
        if (this.saldo <= 0 || this.saldo < valorSaque) {
            return 0;
        }
        return this.saldo - valorSaque;
    }

    public double depositar(double valorDeposito) {
        return this.saldo + valorDeposito;
    }

    @Override
    public double transferir(double valorTransferencia, ContaServiceImpl conta) {
        if (this.saldo <= 0 || this.saldo < valorTransferencia) {
            return 0;
            // Todo: Criar a task para criação de exception
        }
        this.sacar(valorTransferencia);
        conta.depositar(valorTransferencia);
        return valorTransferencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public double getSaldo() {
        return saldo;
    }

}