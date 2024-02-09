package week01.exercise7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.bookData();

        double totalSum = transactions.stream()
                .collect(Collectors.summingInt(Transaction::getAmount));
        System.out.println("Total amount of transactions: " + totalSum);




        Map<String, Integer> totalSumByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency,
                        Collectors.summingInt(Transaction::getAmount)));
        totalSumByCurrency.forEach((currency, sum) ->
                System.out.println("Currency: " + currency + ", Total sum: " + sum));




        Optional<Transaction> highestTransaction = transactions.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Transaction::getAmount)));
        highestTransaction.ifPresent(transaction ->
                System.out.println("Highest Transaction Amount: " + transaction.getAmount()));




        double averageAmount = transactions.stream()
                .collect(Collectors.averagingDouble(Transaction::getAmount));
        System.out.println("Average Transaction Amount: " + averageAmount);
    }
}
