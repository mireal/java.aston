package exercises.fifth;

import java.util.*;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

//        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2011, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");

        Comparator<Transaction> compareTransactionsByValue = Comparator.comparingInt(Transaction::getValue);
        List<Transaction> transactions2011Sorted = transactions.stream().filter(t -> t.getYear() == 2011).sorted(compareTransactionsByValue).toList();

        System.out.println(transactions2011Sorted);

        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");

//        List<String> uniqueCities = traders.stream().map(Trader::getCity).distinct().toList();
        List<String> uniqueCities = transactions.stream().map(t -> t.getTrader().getCity()).distinct().toList();
        System.out.println(uniqueCities);

        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");

        Comparator<Trader> compareTradersByName = Comparator.comparing(Trader::getName);
        List<Trader> cambridgeTradersSorted = transactions.stream().map(Transaction::getTrader).distinct().filter(t -> t.getCity().equals("Cambridge")).sorted(compareTradersByName).toList();
//        List<Trader> cambridgeTradersSorted = traders.stream().filter((t -> t.getCity().equals("Cambridge"))).sorted(compareTradersByName).toList();

        System.out.println(cambridgeTradersSorted);

        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");

//        List<String> traderNamesSorted = traders.stream().map(Trader::getName).sorted().toList();
        List<String> traderNamesSorted = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().toList();
        System.out.println(traderNamesSorted);

        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");

//        boolean hasMilanTraders = traders.stream().anyMatch(t -> t.getCity() == "Milan");
        boolean hasMilanTraders = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("Есть ли трейдеры из Милана: " + hasMilanTraders);

        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        int cambridgeTransactionsSum = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).mapToInt(Transaction::getValue).sum();
        System.out.println("Сумма транзакций трейдеров из кембриджа: " + cambridgeTransactionsSum);

        System.out.println("7. Какова максимальная сумма среди всех транзакций?");

        int maxTransaction = transactions.stream().mapToInt(Transaction::getValue).max().getAsInt();
        System.out.println("Максимальная транзакция: " + maxTransaction);

        System.out.println("8. Найти транзакцию с минимальной суммой.");

        int minTransaction = transactions.stream().mapToInt(Transaction::getValue).min().getAsInt();
        System.out.println("Максимальная транзакция: " + minTransaction);
    }
}
