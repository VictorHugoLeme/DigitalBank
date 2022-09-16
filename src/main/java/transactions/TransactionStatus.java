package transactions;

public enum TransactionStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    DENIED("Denied");

    private final String description;

    TransactionStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
