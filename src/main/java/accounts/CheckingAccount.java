package accounts;

public class CheckingAccount extends BankAccount {

    private static Integer SEQUENCE = 0;

    public CheckingAccount() {
        super.number = String.format("%04d", ++SEQUENCE);
    }
}
