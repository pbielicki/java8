package com.bielu.java8.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bielu.java8.domain.Dish;
import com.bielu.java8.domain.DomainFactory;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

  public static void main(String[] args) {
    List<Dish> dishes = DomainFactory.menu().stream().collect(new ToListCollector<Dish>());
    System.out.println(dishes);
    
    System.out.println(DomainFactory.menu().stream().collect(Collectors.toList()));
    
    dishes = DomainFactory.menu().stream().collect(ArrayList::new, List::add, List::addAll);
    System.out.println(dishes);
  }

  @Override
  public Supplier<List<T>> supplier() {
    return ArrayList::new;
  }

  @Override
  public BiConsumer<List<T>, T> accumulator() {
    return List::add;
  }

  @Override
  public BinaryOperator<List<T>> combiner() {
    return (list1, list2) -> {
      list1.addAll(list2);
      return list1;
    };
  }

  @Override
  public Function<List<T>, List<T>> finisher() {
    return Function.identity();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
  }

}
