package com.bielu.java8.domain;

public class Person {
  private final String firstName;
  private final String lastName;
  private final int age;
  private final Sex sex;

  public Person(String firstName, String lastName, int age, Sex sex) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.sex = sex;
  }

  public String toString() {
    return firstName + " " + lastName + " (" + sex.toString().charAt(0) + " " + age + ")";
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public Sex getSex() {
    return sex;
  }

  public enum Sex {
    MALE, FEMALE
  }
}