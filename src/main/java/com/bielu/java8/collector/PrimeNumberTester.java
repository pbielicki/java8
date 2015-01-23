package com.bielu.java8.collector;

import java.util.stream.IntStream;

public class PrimeNumberTester {

  public static void main(String[] args) {
    int max = 1000;
    int maxrep = 10_000;

    for (int warmUpLoop = 0; warmUpLoop < 10; warmUpLoop++) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < maxrep; i++) {
          IntStream.rangeClosed(2, max)
              .boxed()
              .collect(new PrimeNumberCollector());
        }
        
        if (warmUpLoop == 9) {
          System.out.println("Collector: " + (System.currentTimeMillis() - start) + " ms");
        }
        
        start = System.currentTimeMillis();
        for (int i = 0; i < maxrep; i++) {
          new PrimeNumberImperative(2, max).collect();
        }
        
        if (warmUpLoop == 9) {
          System.out.println("Imperative: " + (System.currentTimeMillis() - start) + " ms");
        }
    }
  }
}
