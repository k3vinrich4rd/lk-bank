package test;

import exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ContaCorrente;

class ContaCorrenteTest {

    private ContaCorrente contaCorrente1;
    private ContaCorrente contaCorrente2;

    @BeforeEach
    void setUp() {
        contaCorrente1 = new ContaCorrente(123, "Kevin Richard", "333", 300);
        contaCorrente2 = new ContaCorrente(321, "Jose fumi", "333", 200);
    }

    @Test
    @DisplayName("Sacar valor com taxa de 5%")
    void sacar() {
        contaCorrente1.sacar(200.00);
        Assertions.assertEquals(90.00, contaCorrente1.getSaldo(), 0.01);
    }

    @Test
    @DisplayName("Saque com saldo insuficiente deve lançar exceção")
    void sacarSaldoInsuficiente() {
        Assertions.assertThrows(
                SaldoInsuficienteException.class,
                () -> contaCorrente1.sacar(1000.00)
        );
    }

    @Test
    @DisplayName("Transferir valor para outra conta")
    void transferir() {
        contaCorrente1.transferir(200.00, contaCorrente2);
        Assertions.assertEquals(400.00, contaCorrente2.getSaldo(), 0.01);
    }

    @Test
    @DisplayName("Transferência com saldo insuficiente deve lançar exceção")
    void transferirSaldoInsuficiente() {
        Assertions.assertThrows(
                SaldoInsuficienteException.class,
                () -> contaCorrente1.transferir(500.00, contaCorrente2)
        );
    }
}