package banks;

import accounts.AccountTypes;
import accounts.BankAccount;
import accounts.CheckingAccount;
import accounts.SavingsAccount;
import entity.Client;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Agency {
    private static Integer SEQUENCE = 0;

    @Getter
    private final String number;
    @Getter
    private final Bank bank;
    @Getter
    private final Set<Client> clients = new HashSet<>();
    @Getter
    private final Set<BankAccount> accounts = new HashSet<>();

    public Agency(Bank bank) {
        this.bank = bank;
        this.number = String.format("%04d", ++SEQUENCE);
    }

    public BankAccount createAccount(Client client, AccountTypes accountType) {
        BankAccount account;
        if(accountType == AccountTypes.CHECKING) {
            account = new CheckingAccount();
        } else {
            account = new SavingsAccount();
        }
        account.setClient(client);
        account.setAgency(this.getNumber());

        this.clients.add(client);
        this.accounts.add(account);

        client.addAccount(account);
        return account;
    }

    public void removeAccount(BankAccount account) {
        this.accounts.remove(account);
        this.clients.remove(account.getClient());
    }

}
