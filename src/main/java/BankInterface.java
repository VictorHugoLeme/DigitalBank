import accounts.CheckingAccount;
import banks.Agency;
import banks.Bank;
import entity.Client;

public class BankInterface {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("Creating new bank");

        Bank bank = new Bank("Parceiria banks.Bank");
        System.out.println("banks.Bank name:" + bank.getName());

        System.out.println("--------------------------------------------------");
        System.out.println("Creating new agencies");

        Agency agency1 = bank.createAgency();
        Agency agency2 = bank.createAgency();
        System.out.println("banks.Agency 1 number: " + agency1.getNumber());
        System.out.println("banks.Agency 2 number: " + agency2.getNumber());

        System.out.println("--------------------------------------------------");
        System.out.println("Creating new clients and accounts");

        Client victor = agency1.addClient("Victor", "12345678901");
        CheckingAccount accountVictor1 =  victor.createCheckingAccount(agency1.getNumber());
        System.out.println("entity.Client 1 name: " + victor.getName());
        System.out.println("Account 1 number: " + accountVictor1.getNumber());

        Client hugo = agency2.addClient("Hugo", "12345678901");
        CheckingAccount accountHugo1 =  hugo.createCheckingAccount(agency2.getNumber());
        System.out.println("entity.Client 2 name: " + hugo.getName());
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
