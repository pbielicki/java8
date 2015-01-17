package com.bielu.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionStreams {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    
    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );
    
    // all trans. in 2011 sorted by value ascending
    List<Transaction> tr2011 = transactions.stream()
      .filter(t -> t.getYear() == 2011)
      .sorted(Comparator.comparing(Transaction::getValue))
      .collect(Collectors.toList());
    
    System.out.println(tr2011);

    // unique cities
    List<String> cities = transactions.stream()
      .map(t -> t.getTrader().getCity())
      .distinct()
      .collect(Collectors.toList());
    
    System.out.println(cities);

    // traders from Cambridge
    transactions.stream()
      .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
      .map(Transaction::getTrader)
      .sorted(Comparator.comparing(Trader::getName))
      .distinct()
      .forEach(System.out::println);
    
    // string of all traders' names sorted alphabetically
    System.out.println(transactions.stream()
      .map(t -> t.getTrader().getName())
      .distinct()
      .sorted()
      .reduce("", (a, b) -> a + b)); // inefficient
    
    // are any traders in Milan
    boolean anyoneInMilan = transactions.stream()
        .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
    
    System.out.println("Anyone in Milan: " + anyoneInMilan);
    
    // values of all transactions in Cambridge
    List<Integer> valuesCambridge = transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .collect(Collectors.toList());
    
    System.out.println(valuesCambridge);
  }

}
