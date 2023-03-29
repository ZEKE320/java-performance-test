package com.github.zeke320.util;

public class NanoTimePrinter {

  public static void printExecutionTimeInNanos(Runnable method) {
    long startTime = System.nanoTime();
    method.run();
    long endTime = System.nanoTime();
    System.out.printf("Execution Time: %8dns\n", endTime - startTime);
  }
}
