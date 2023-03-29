package com.github.zeke320.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.github.zeke320.util.NanoTimePrinter;
import com.github.zeke320.util.RandomListGenerator;

public class RoopSpeedComparator {
  private static final int MAX_LIST_SIZE = 10000;

  public List<String> roopByForEach(List<String> list) {
    List<String> newList = new ArrayList<>();
    list.forEach(newList::add);
    return newList;
  }

  public List<String> roopBySimpleFor(List<String> list) {
    List<String> newList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      newList.add(list.get(i));
    }
    return newList;
  }

  public List<String> roopByExtendedFor(List<String> list) {
    List<String> newList = new ArrayList<>();
    for (String str : list) {
      newList.add(str);
    }
    return newList;
  }

  public List<String> roopByAddAll(List<String> list) {
    List<String> newList = new ArrayList<>();
    newList.addAll(list);
    return newList;
  }

  public List<String> roopByStreamForEach(List<String> list) {
    List<String> newList = new ArrayList<>();
    list.stream().forEach(newList::add);
    return newList;
  }

  public List<String> roopByStreamCollectorsToList(List<String> list) {
    return list.stream().map(str -> str).collect(Collectors.toList());
  }

  public List<String> roopByStreamToList(List<String> list) {
    return list.stream().map(str -> str).toList(); // Immutable List
  }

  public List<String> roopByIntStreamForEach(List<String> list) {
    List<String> newList = new ArrayList<>();
    IntStream.range(1, list.size()).forEach(n -> newList.add(list.get(n)));
    return newList;
  }

  public static void test() {
    RoopSpeedComparator comparator = new RoopSpeedComparator();
    List<String> list = RandomListGenerator.initializeRandomStringList(MAX_LIST_SIZE);
    System.out.println("-- roopByForEach");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByForEach(list));
    System.out.println("-- roopBySimpleFor");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopBySimpleFor(list));
    System.out.println("-- roopByExtendedFor");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByExtendedFor(list));
    System.out.println("-- roopByAddAll");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByAddAll(list));
    System.out.println("-- roopByStreamForEach");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByStreamForEach(list));
    System.out.println("-- roopByStreamCollectorsToList");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByStreamCollectorsToList(list));
    System.out.println("-- roopByStreamToList");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByStreamToList(list));
    System.out.println("-- roopByIntStreamForEach");
    NanoTimePrinter.printExecutionTimeInNanos(() -> comparator.roopByIntStreamForEach(list));
  }
}

