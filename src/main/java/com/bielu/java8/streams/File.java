package com.bielu.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class File {

  public static void main(String[] args) {
    long uniqueWords = 0;
    try (Stream<String> lines = Files.lines(Paths.get("text_file.txt"))) {
      uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
          .map(word -> word.toLowerCase())
          .distinct()
          .count();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    System.out.println("Unique words: " + uniqueWords);
  }
}
