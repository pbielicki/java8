package com.bielu.java8.datacollection;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.bielu.java8.domain.Dish;
import com.bielu.java8.domain.Dish.CaloricLevel;
import com.bielu.java8.domain.Dish.DishType;
import com.bielu.java8.domain.DomainFactory;

public class Grouping {

  public static void main(String[] args) {
    Map<DishType, List<Dish>> dishesByType = DomainFactory.menu()
        .stream()
        .collect(Collectors.groupingBy(Dish::getType));
    
    System.out.println(dishesByType);
    
    // multilevel grouping
    Map<DishType, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
        DomainFactory.menu()
        .stream()
        .collect(Collectors.groupingBy(Dish::getType,
            Collectors.groupingBy(dish -> {
              if (dish.getCalories() <= 400) return CaloricLevel.DIET;
              if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
              return CaloricLevel.FAT;
            })));
    
    System.out.println(dishesByTypeCaloricLevel);
    
    // subgroups
    Map<DishType, Long> typesCount = DomainFactory.menu()
        .stream()
        .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
    
    Map<DishType, Optional<Dish>> mostCaloricByTypeOptional =
        DomainFactory.menu()
        .stream()
        .collect(Collectors.groupingBy(
            Dish::getType, Collectors.maxBy(
                Comparator.comparing(Dish::getCalories))));

    Map<DishType, Dish> mostCaloricByType =
        DomainFactory.menu()
        .stream()
        .collect(Collectors.groupingBy(Dish::getType, 
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(Dish::getCalories)),
                Optional::get)));
    
    System.out.println(typesCount);
    System.out.println(mostCaloricByTypeOptional);
    System.out.println(mostCaloricByType);
    
    Map<DishType, Set<CaloricLevel>> caloricLevelsByType =
        DomainFactory.menu()
        .stream()
        .collect(Collectors.groupingBy(Dish::getType,
            Collectors.mapping(dish -> {
              if (dish.getCalories() <= 400) return CaloricLevel.DIET;
              if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
              return CaloricLevel.FAT;
            }, Collectors.toSet())));
    
    System.out.println(caloricLevelsByType);
  }

}
