package com.github.zeke320;

import com.github.zeke320.tester.RoopSpeedComparator;
import com.github.zeke320.tester.StringBuildSpeedComparator;

public class Application {
  public static void main(String[] args) {
    System.out.println("- StringBuildSpeedComparator");
    StringBuildSpeedComparator.test();
    System.out.println("\n- RoopSpeedComparator");
    RoopSpeedComparator.test();
  }
}
