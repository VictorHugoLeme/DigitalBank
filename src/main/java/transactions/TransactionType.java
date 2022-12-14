package transactions;

public enum TransactionType {
    WITHDRAW("Withdraw"),
    DEPOSIT("Deposit"),
    TRANSFER("Transfer"),
    PAYMENT("Payment");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
