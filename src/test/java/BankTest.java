import banks.Agency;
import banks.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {

    @Test
    void shouldCreateAgency() {
        Bank bank = new Bank("Bank1");
        Agency agency1 = bank.createAgency();
        Agency agency2 = bank.createAgency();

        assertEquals("Bank1", bank.getName());
        assertEquals(2, bank.getAgencies().size());
        assertEquals(4, agency1.getNumber().length());
        assertEquals(4, agency2.getNumber().length());

    }
}