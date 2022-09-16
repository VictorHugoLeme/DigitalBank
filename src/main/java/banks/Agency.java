package banks;

import entity.Client;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private static Integer SEQUENCE = 0;

    @Getter
    private final String number;
    @Getter
    private final Bank bank;
    @Getter
    private final List<Client> clients = new ArrayList<>();

    public Agency(Bank bank) {
        this.bank = bank;
        this.number = String.format("%04d", ++SEQUENCE);
    }

    public Client addClient(String name, String cpf) {
        Client client = new Client(name, cpf);
        client.addAgency(this);
        this.clients.add(client);
        return client;
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }

}
