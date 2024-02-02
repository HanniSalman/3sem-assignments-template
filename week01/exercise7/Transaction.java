package week01.exercise7;

import java.util.List;

public class Transaction {
    private int id;
    private int amount;
    private String currency;

    public Transaction(int id, int amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public static List<Transaction> bookData() {
        return List.of(
                new Transaction(1, 100, "DKK"),
                new Transaction(2, 200, "SWE"),
                new Transaction(3, 300, "LDK"),
                new Transaction(4, 150, "DKK"),
                new Transaction(5, 250, "SWE"),
                new Transaction(6, 350, "LDK")
        );
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
