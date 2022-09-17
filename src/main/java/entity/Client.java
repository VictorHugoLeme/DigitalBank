package entity;

import accounts.BankAccount;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Client {

    @NonNull
    @Getter
    @Setter
    private String name;
    @NonNull
    @Getter
    @Setter
    private String cpf;
    @Getter
    private final Set<BankAccount> accounts = new HashSet<>();

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public String toString() {
        return "Client: " + this.name + " - " + this.cpf;
    }
}
