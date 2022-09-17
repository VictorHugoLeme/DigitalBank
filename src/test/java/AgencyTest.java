import accounts.AccountTypes;
import accounts.BankAccount;
import accounts.CheckingAccount;
import accounts.SavingsAccount;
import banks.Agency;
import banks.Bank;
import entity.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgencyTest {

    @Test
    void shouldSuccessfullyCreateAgency() {
        Bank bank = Mockito.mock(Bank.class);
        Mockito.when(bank.getName()).thenReturn("Bank");
        Agency agency = new Agency(bank);
        assertEquals(4, agency.getNumber().length());
        assertEquals("Bank", agency.getBank().getName());
    }

    @Test
    void shouldSuccessfullyAddAccount() {
        Bank bank = Mockito.mock(Bank.class);
        Mockito.when(bank.getName()).thenReturn("Bank");
        Agency agency = new Agency(bank);
        Client client = new Client("Name2", "12345678900");

        agency.createAccount(client, AccountTypes.CHECKING);
        assertEquals(1, agency.getAccounts().size());
        assertEquals(1, agency.getClients().size());
        agency.createAccount(client, AccountTypes.SAVINGS);
        assertEquals(2, agency.getAccounts().size());
        assertEquals(1, agency.getClients().size());
        System.out.println(agency.getAccounts().toString());
    }

    @Test
    void shouldSuccessfullyRemoveAccount() {
        Bank bank = Mockito.mock(Bank.class);
        Mockito.when(bank.getName()).thenReturn("Bank");
        Agency agency = new Agency(bank);
        BankAccount account =  agency.createAccount(new Client("Name2", "12345678901"), AccountTypes.CHECKING);
        agency.removeAccount(account);
        assertEquals(0, agency.getAccounts().size());
    }
}