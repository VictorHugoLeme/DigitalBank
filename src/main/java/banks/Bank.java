package banks;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    @Getter
    private final String name;
    @Getter
    private final List<Agency> agencies = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Agency createAgency() {
        Agency agency = new Agency(this);
        this.agencies.add(agency);
        return agency;
    }
}
