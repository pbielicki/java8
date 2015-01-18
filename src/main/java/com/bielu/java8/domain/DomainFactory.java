package com.bielu.java8.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.bielu.java8.domain.Dish.DishType;

public final class DomainFactory {

  private DomainFactory() {
  }
  
  public static List<Dish> menu() {
    return Collections.unmodifiableList(Arrays.asList(
        new Dish("pork", false, 800, DishType.MEAT),
        new Dish("beef", false, 700, DishType.MEAT),
        new Dish("chicken", false, 400, DishType.MEAT),
        new Dish("french fries", true, 530, DishType.OTHER),
        new Dish("rice", true, 350, DishType.OTHER),
        new Dish("season fruit", true, 120, DishType.OTHER),
        new Dish("pizza", true, 550, DishType.OTHER),
        new Dish("prawns", false, 300, DishType.FISH),
        new Dish("salmon", false, 450, DishType.FISH)
    ));
  }
  
  public static List<Transaction> transactions() {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    
    return Collections.unmodifiableList(Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    ));
  }
}
