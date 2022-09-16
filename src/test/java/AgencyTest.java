import banks.Agency;
import banks.Bank;
import entity.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgencyTest {

    @Test
    void shouldSuccessfullyAddANewClient() {
        Bank bank = new Bank("Bank1");
        Agency agency = new Agency(bank);
        Client client = agency.addClient("Test1", "12345678900");

        assertEquals("Test1", client.getName());
        assertEquals("12345678900", client.getCpf());
        assertEquals(1, agency.getClients().size());
        assertEquals(1, client.getAgencies().size());
        assertEquals("Bank1", client.getAgencies().get(0).getBank().getName());
    }

    @Test
    void shouldSuccessfullyDeleteAClient() {
        Bank bank = new Bank("Bank2");
        Agency agency2 = new Agency(bank);
        Client client = agency2.addClient("Test2", "12345678900");
        assertEquals(1, agency2.getClients().size());
        agency2.removeClient(client);
        assertEquals(0, agency2.getClients().size());
    }
}