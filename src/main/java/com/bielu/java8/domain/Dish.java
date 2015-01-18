package com.bielu.java8.domain;

public class Dish {

  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final DishType type;

  public Dish(String name, boolean vegetarian, int calories, DishType type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public int getCalories() {
    return calories;
  }

  public DishType getType() {
    return type;
  }
  
  @Override
  public String toString() {
    return name;
  }

  public enum DishType {
    MEAT, FISH, OTHER;
  }
  
  public enum CaloricLevel {
    DIET, NORMAL, FAT;
  }
}
