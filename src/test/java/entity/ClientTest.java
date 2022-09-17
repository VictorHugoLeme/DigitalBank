package entity;

import accounts.BankAccount;
import accounts.CheckingAccount;
import accounts.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void shouldSuccessWhenCreatingNewClient() {
        Client client = new Client("Name1", "12345678900");
        assertEquals("Name1", client.getName());
        assertEquals("12345678900", client.getCpf());
        assertEquals("Client: Name1 - 12345678900", client.toString());
    }

    @Test
    void shouldSuccessWhenSettingClientsName() {
        Client client = new Client("Name1", "12345678900");
        client.setName("Name2");
        assertEquals("Name2", client.getName());
    }
    @Test
    void shouldSuccessWhenSettingClientsCpf() {
        Client client = new Client("Name1", "12345678900");
        client.setCpf("12345678901");
        assertEquals("12345678901", client.getCpf());
    }

    @Test
    void shouldSuccessWhenAddingNewAccount() {
        Client client = new Client("Name1", "12345678900");
        BankAccount account = new CheckingAccount();
        client.addAccount(account);
        assertTrue(client.getAccounts().contains(account));
        assertEquals(1, client.getAccounts().size());
        BankAccount account2 = new SavingsAccount();
        client.addAccount(account2);
        assertTrue(client.getAccounts().contains(account2));
        assertEquals(2, client.getAccounts().size());
    }
}