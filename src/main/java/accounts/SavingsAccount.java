package accounts;

public class SavingsAccount extends BankAccount {

    private static Integer SEQUENCE = 0;

    public SavingsAccount() {
        super.number = String.format("%04d", ++SEQUENCE);
    }

}
