package com.github.zeke320.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class StringBuildSpeedComparator {
  private static final int MAX_LIST_SIZE = 10000;

  private void runWithPlusOperator(List<String> list) {
    String str1 = "abc" + "abc" + "abc";
    list.add(str1);
  }

  private void runWithRecursivePlusOperator(List<String> list) {
    String str2 = "";
    for (int i = 0; i < 3; i++) {
      str2 += "abc";
    }
    list.add(str2);
  }

  private void runWithStringBuilder(List<String> list) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      stringBuilder.append("abc");
    }
    list.add(stringBuilder.toString());
  }

  public static void test() {
    StringBuildSpeedComparator comparator = new StringBuildSpeedComparator();
    List<String> strList1 = new ArrayList<>();
    List<String> strList2 = new ArrayList<>();
    List<String> strList3 = new ArrayList<>();

    long time1 = System.nanoTime();

    // 1: 6474200ns
    // 2: 7374100ns
    // 3: 5593600ns
    IntStream.rangeClosed(0, 10000).forEach(n -> comparator.runWithPlusOperator(strList1));
    long time2 = System.nanoTime();

    // 1: 6392400ns
    // 2: 6774300ns
    // 3: 5722900ns
    IntStream.rangeClosed(0, 10000).forEach(n -> comparator.runWithRecursivePlusOperator(strList2));
    long time3 = System.nanoTime();

    // 1: 2423600ns
    // 2: 2592800ns
    // 3: 2373400ns
    IntStream.rangeClosed(0, 10000).forEach(n -> comparator.runWithStringBuilder(strList3));
    long time4 = System.nanoTime();

    System.out.println("-- runWithPlusOperator");
    System.out.println(time2 - time1);
    System.out.println("-- runWithRecursivePlusOperator");
    System.out.println(time3 - time2);
    System.out.println("-- runWithStringBuilder");
    System.out.println(time4 - time3);

    IntStream.rangeClosed(0, 10000).forEach(index -> {
      if (Objects.equals(strList1.get(index), strList2.get(index))
          && Objects.equals(strList2.get(index), strList3.get(index))) {
        return;
      }
      throw new IllegalStateException();
    });
  }
}

