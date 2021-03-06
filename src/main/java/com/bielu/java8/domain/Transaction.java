package com.bielu.java8.domain;

public class Transaction {

  private final Trader trader;
  private final int year;
  private final int value;

  Transaction(Trader trader, int year, int value) {
    this.trader = trader;
    this.year = year;
    this.value = value;
  }

  public Trader getTrader() {
    return trader;
  }

  public int getYear() {
    return year;
  }

  public int getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return "[" + trader + ", " + year + ", " + value + "]";
  }
}
