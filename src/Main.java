import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.*;
import java.util.concurrent.Executors;

public class Main {

    public static void addUniqueList(List<List<Integer>> res, List<Integer> newList) {
        Set<List<Integer>> set = new HashSet<>(res); // Convert to set for easy checking of uniqueness
        if (!set.contains(newList)) {
            res.add(newList); // Add only if the list is not already in the set
        }
    }
    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> al1 = new ArrayList<>();
        al1.add(1); al1.add(2); al1.add(3);

        List<Integer> al2 = new ArrayList<>();
        al2.add(1);al2.add(1); al2.add(2); al2.add(3);

        addUniqueList(res, al1);
        addUniqueList(res, al2);

        System.out.println("Resulting list: " + res);
    }
}