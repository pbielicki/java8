package com.bielu.java8.datacollection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Partitioning {

  public static boolean isPrime(int candidate) {
    int candidateRoot = (int) Math.sqrt((double) candidate);
    return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
  }

  public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
    return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
  }

  public static void main(String[] args) {
    partitionPrimes(1000).forEach((k, v) -> { if (k == true) System.out.println(v); });
  }

}
