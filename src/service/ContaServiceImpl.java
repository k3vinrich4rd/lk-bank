package service;

import java.util.Random;

import enums.ExceptionsEnum;
import exception.SaldoInsuficienteException;

public abstract class ContaServiceImpl implements ContaService {

    private int numeroConta;
    private String nomeTitular;
    private String cpf;
    private String cpfF;

    private double saldo;

    Random random = new Random();

    public ContaServiceImpl() {
    }

    public ContaServiceImpl(String nomeTitular, String cpf, double saldo) {
        this.numeroConta = random.nextInt(999999);
        this.nomeTitular = nomeTitular;
        this.cpfF = formatarCpf(cpf);
        this.saldo = saldo;
    }
    

    public ContaServiceImpl(int numeroConta, String nomeTitular, String cpfF, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.cpfF = cpfF;
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
    public double transferir(double valorTransferencia, ContaService conta) {
        if (this.saldo <= 0 || this.saldo < valorTransferencia) {
            throw new SaldoInsuficienteException(
                    ExceptionsEnum.SALDO_INSUFICIENTE.getMessage(valorTransferencia, saldo));
        }
        this.sacar(valorTransferencia);
        conta.depositar(valorTransferencia);
        return valorTransferencia;
    }

    public static String formatarCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return cpf = null;
        } else {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
    }

    public String fileWriter(ContaServiceImpl conta) {
        return String.valueOf(numeroConta) + " " + nomeTitular + " " + cpfF + " " + saldo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpfF() {
        return cpfF;
    }

    public void setCpfF(String cpfF) {
        this.cpfF = cpfF;
    }

    public double getSaldo() {
        return saldo;
    }

}