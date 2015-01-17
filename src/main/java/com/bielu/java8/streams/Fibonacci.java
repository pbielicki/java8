package com.bielu.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Fibonacci {

  public static void main(String[] args) {
    Stream.iterate(new int[] {0,  1}, f -> new int[] {f[1], f[0] + f[1]})
      .limit(20)
      .map(Arrays::toString)
      .forEach(System.out::print);
  }

}
