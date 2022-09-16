package accounts;

import entity.Client;
import lombok.Getter;
import lombok.Setter;
import transactions.Transaction;
import transactions.TransactionStatus;
import transactions.TransactionType;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    @Getter
    @Setter
    protected String agency;
    @Getter
    protected String number;
    @Getter
    @Setter
    private Client client;
    @Getter
    protected Double balance = 0.0;
    @Getter
    private final List<Transaction> extract = new ArrayList<>();

    public Double withdraw(Double amount) {
        if (this.balance >= amount) {
            extract.add(new Transaction(amount, TransactionType.WITHDRAW, this.balance, TransactionStatus.ACCEPTED));
            this.balance -= amount;
            return amount;
        } else {
            extract.add(new Transaction(amount, TransactionType.WITHDRAW, this.balance, TransactionStatus.DENIED));
            throw new IllegalArgumentException("Insufficient funds");
        }
    };

    public Double deposit(Double amount) {
        extract.add(new Transaction(amount, TransactionType.DEPOSIT, this.balance, TransactionStatus.ACCEPTED));
        this.balance += amount;
        return this.balance;
    }

    public Double transfer(Double amount, BankAccount destination) {
        if (this.balance >= amount) {
            destination.deposit(amount);
            extract.add(new Transaction(amount, TransactionType.TRANSFER, this.balance, TransactionStatus.ACCEPTED));
            this.balance -= amount;
            return this.balance;
        } else {
            extract.add(new Transaction(amount, TransactionType.WITHDRAW, this.balance, TransactionStatus.DENIED));
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

}
