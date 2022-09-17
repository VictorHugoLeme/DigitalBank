import accounts.AccountTypes;
import accounts.BankAccount;
import accounts.CheckingAccount;
import banks.Agency;
import banks.Bank;
import entity.Client;

public class BankInterface {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("Creating new bank");

        Bank bank = new Bank("Parceiria Bank");
        System.out.println("Bank name:" + bank.getName());

        System.out.println("--------------------------------------------------");
        System.out.println("Creating new agencies");

        Agency agency1 = bank.createAgency();
        Agency agency2 = bank.createAgency();
        System.out.println("Agency 1 number: " + agency1.getNumber());
        System.out.println("Agency 2 number: " + agency2.getNumber());

        System.out.println("--------------------------------------------------");
        System.out.println("Creating new clients and accounts");

        Client victor = new Client("Victor", "12345678900");
        BankAccount accountVictor1 =  agency1.createAccount(victor, AccountTypes.CHECKING);
        System.out.println("Client 1 name: " + victor.getName());
        System.out.println("Account 1 number: " + accountVictor1.getNumber());

        Client hugo = new Client("Hugo", "12345678901");
        BankAccount accountHugo1 =  agency2.createAccount(hugo, AccountTypes.SAVINGS);
        System.out.println("Client 2 name: " + hugo.getName());
        System.out.println("Account 2 number: " + accountHugo1.getNumber());

        System.out.println("--------------------------------------------------");
        System.out.println("Making some transactions");

        System.out.println("Account 1 balance: " + accountVictor1.getBalance());
        System.out.println("Depositing 1000.00 into account 1");
        accountVictor1.deposit(1000.0);
        System.out.println("Account 1 balance: " + accountVictor1.getBalance());
        System.out.println("Transferring 100.00 from account 1 to account 2");
        accountVictor1.transfer(100.0, accountHugo1);
        System.out.println("Account 1 balance: " + accountVictor1.getBalance());
        System.out.println("Account 2 balance: " + accountHugo1.getBalance());

        System.out.println("Transferring 50.00 from account 2 to account 1");
        accountHugo1.transfer(50.0, accountVictor1);
        System.out.println("Account 1 balance: " + accountVictor1.getBalance());
        System.out.println("Account 2 balance: " + accountHugo1.getBalance());

        System.out.println("--------------------------------------------------");
        System.out.println("Getting the Extracts");

        System.out.println("Account 1 Extract: [");
        accountVictor1.getExtract().forEach(System.out::println);
        System.out.println("]");

        System.out.println("Account 2 Extract: [");
        accountHugo1.getExtract().forEach(System.out::println);
        System.out.println("]");
    }
}
