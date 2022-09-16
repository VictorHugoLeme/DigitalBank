package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDateTime date;
    private final Double value;
    private final TransactionType type;
    private final Double balanceBefore;
    private final Double balanceAfter;
    private final TransactionStatus status;

    public Transaction(Double value, TransactionType type, Double balanceBefore, TransactionStatus status) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.balanceBefore = balanceBefore;
        this.status = status;
        if(status== TransactionStatus.ACCEPTED) {
            switch (type) {
                case WITHDRAW:
                case TRANSFER:
                    this.balanceAfter = balanceBefore - value;
                    this.value = -value;
                    break;
                case DEPOSIT:
                    this.balanceAfter = balanceBefore + value;
                    this.value = value;
                    break;
                default:
                    this.balanceAfter = balanceBefore;
                    this.value = value;
            }
        } else {
            this.balanceAfter = balanceBefore;
            this.value = value;
        }



    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date.format(formatter) +
                ", value=" + value +
                ", type=" + type +
                ", balanceBefore=" + balanceBefore +
                ", balanceAfter=" + balanceAfter +
                ", status=" + status +
                '}';
    }

}
