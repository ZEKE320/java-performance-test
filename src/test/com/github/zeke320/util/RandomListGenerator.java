package com.github.zeke320.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RandomListGenerator {
  public static List<String> initializeRandomStringList(int size) {
    List<String> randomStrings = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      String randomString = UUID.randomUUID().toString();
      randomStrings.add(randomString);
    }
    return randomStrings;
  }
}
