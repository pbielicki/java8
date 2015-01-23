package com.bielu.java8.collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeNumberImperative {

  private int min;
  private int max;

  public PrimeNumberImperative(int min, int max) {
    this.min = min;
    this.max = max;
  }

  @SuppressWarnings("serial")
  public Map<Boolean, List<Integer>> collect() {
    Map<Boolean, List<Integer>> result = new HashMap<Boolean, List<Integer>>() {
      {
        put(true, new ArrayList<>());
        put(false, new ArrayList<>());
      }
    };
    
    for (int candidate = min; candidate <= max; candidate++) {
      result.get(PrimeNumberCollector.isPrime(result.get(true), candidate)).add(candidate);
    }
    
    return result;
  }
  
}
