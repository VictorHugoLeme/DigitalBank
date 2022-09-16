package entity;

import accounts.CheckingAccount;
import accounts.SavingsAccount;
import banks.Agency;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Client {
    @NonNull
    private String name;
    @NonNull
    private String cpf;
    private List<Agency> agencies = new ArrayList<>();

    public void addAgency(Agency agency) {
        this.agencies.add(agency);
    }

    public CheckingAccount createCheckingAccount(String agency) {
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setClient(this);
        checkingAccount.setAgency(this.agencies.stream().filter(a -> a.getNumber().equals(agency)).findFirst().orElseThrow().getNumber());
        return checkingAccount;
    }

    public SavingsAccount createSavingsAccount(String agency) {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setClient(this);
        savingsAccount.setAgency(this.agencies.stream().filter(a -> a.getNumber().equals(agency)).findFirst().orElseThrow().getNumber());
        return savingsAccount;
    }

    public String toString() {
        return "entity.Client: " + this.name + " - " + this.cpf;
    }
}
