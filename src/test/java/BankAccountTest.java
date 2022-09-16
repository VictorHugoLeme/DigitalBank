import accounts.CheckingAccount;
import banks.Agency;
import banks.Bank;
import entity.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void shouldUpdateBalanceWhenMakingValidTransactions() {
        CheckingAccount checkingAccount = new CheckingAccount();
        CheckingAccount checkingAccount2 = new CheckingAccount();
        assertEquals(100.00, checkingAccount.deposit(100.0));
        assertEquals(50.0, checkingAccount.withdraw(50.0));
        assertEquals(0.0, checkingAccount.transfer(50.0, checkingAccount2));
    }

    @Test
    void shouldThrowExceptionWhenMakingInvalidTransactions() {
        CheckingAccount checkingAccount = new CheckingAccount();
        CheckingAccount checkingAccount2 = new CheckingAccount();
        assertEquals(100.00, checkingAccount.deposit(100.0));
        assertThrows(IllegalArgumentException.class, () -> checkingAccount.withdraw(150.0));
        assertThrows(IllegalArgumentException.class, () -> checkingAccount.transfer(150.0, checkingAccount2));
    }

    @Test
    void shouldSuccessfullySetAndGetAAccountsClient() {
        CheckingAccount checkingAccount = new CheckingAccount();
        Client client = new Client("Client1", "12345678901");
        checkingAccount.setClient(client);
        assertEquals(client, checkingAccount.getClient());

    }

    @Test
    void shouldSuccessfullyAddTransactionsToExtract() {
        CheckingAccount checkingAccount1 = new CheckingAccount();
        CheckingAccount checkingAccount2 = new CheckingAccount();
        assertEquals(0, checkingAccount1.getExtract().size());

        checkingAccount1.deposit(100.0);
        checkingAccount2.deposit(100.0);
        assertEquals(1, checkingAccount1.getExtract().size());

        checkingAccount2.withdraw(50.0);
        assertEquals(2, checkingAccount2.getExtract().size());

        checkingAccount1.transfer(50.0, checkingAccount2);
        assertEquals(2, checkingAccount1.getExtract().size());
        assertEquals(3, checkingAccount2.getExtract().size());

        assertThrows(IllegalArgumentException.class, () -> checkingAccount1.withdraw(100.0));
        assertEquals(3, checkingAccount1.getExtract().size());
    }

    @Test
    void shouldSuccessfullyGetAccountNumber() {
        CheckingAccount checkingAccount = new CheckingAccount();
        assertEquals(4, checkingAccount.getNumber().length());
    }
    @Test
    void shouldSuccessfullyGetAgencyNumber() {
        Bank bank = new Bank("Bank1");
        Agency agency = new Agency(bank);
        CheckingAccount checkingAccount = agency.addClient("Client1", "12345678901").createCheckingAccount(agency.getNumber());

        assertEquals(4, checkingAccount.getAgency().length());
    }
}