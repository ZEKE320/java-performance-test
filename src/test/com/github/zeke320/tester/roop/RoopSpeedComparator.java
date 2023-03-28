import java.util.ArrayList;
import java.util.List;

public class RoopSpeedComparator {

  public static List<String> roopByForEach(List<String> list) {
    List<String> newList = new ArrayList<>();
    list.forEach(newList::add);
  }

  public static List<String> roopBySimpleFor(List<String> list) {
    List<String> newList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      newList.add(list.get(i));
    }
  }

  public static List<String> roopByExtendedFor(List<String> list) {
    List<String> newList = new ArrayList<>();
    for (String str : list) {
      newList.add(str);
    }
  }

  public static void main(String[] args) {
    NanoTimePrinter.printExecutionTimeInNanos();
  }
}

