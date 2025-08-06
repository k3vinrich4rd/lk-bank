package enums;

public enum ExceptionsEnum {
    SALDO_INSUFICIENTE("Impossível efetuar transação, saldo insuficiente. Valor da transação: %.2f - Saldo disponível: %.2f");

    private final String message;

    ExceptionsEnum(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
