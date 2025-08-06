package service;

import enums.ExceptionsEnum;
import exception.SaldoInsuficienteException;

public abstract class ContaServiceImpl implements ContaService {

    private int numeroConta;
    private String nomeTitular;
    private String CPF;
    private double saldo;

    public ContaServiceImpl() {
    }

    public ContaServiceImpl(int numeroConta, String nomeTitular, String cPF, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        CPF = cPF;
        this.saldo = saldo;
    }

    public double sacar(double valorSaque) {
        if (this.saldo <= 0 || this.saldo < valorSaque) {
            throw new SaldoInsuficienteException(ExceptionsEnum.SALDO_INSUFICIENTE.getMessage(valorSaque, saldo));
        }
        return this.saldo -= valorSaque;
    }

    public double depositar(double valorDeposito) {
        return this.saldo += valorDeposito;
    }

    @Override
    public double transferir(double valorTransferencia, ContaServiceImpl conta) {
        if (this.saldo <= 0 || this.saldo < valorTransferencia) {
            throw new SaldoInsuficienteException(ExceptionsEnum.SALDO_INSUFICIENTE.getMessage(valorTransferencia, saldo));
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