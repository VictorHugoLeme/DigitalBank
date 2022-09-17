package accounts;

public enum AccountTypes {
    CHECKING("Checking"),
    SAVINGS("Savings");

    private final String description;

    AccountTypes(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
