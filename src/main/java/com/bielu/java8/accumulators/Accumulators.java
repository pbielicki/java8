package com.bielu.java8.accumulators;

import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import com.bielu.java8.domain.DomainFactory;
import com.bielu.java8.domain.Person;
import com.bielu.java8.domain.Person.Sex;

public class Accumulators {
  public static void main(String[] args) {
    List<Person> people = DomainFactory.people();
    final LongAdder adder = new LongAdder();
    final LongAccumulator acc = new LongAccumulator(Long::sum, 0);
    people.stream().filter(p -> p.getAge() >= 18).filter(p -> Sex.FEMALE == p.getSex()).forEach(p -> {
      acc.accumulate(p.getAge());
      adder.increment();
    });
    System.out.println("Average male adult age: " + acc.intValue() / adder.intValue());
  }
}