package data;


import java.util.*;

public class Counterparts {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6);

        Set<Integer> aSet = new HashSet<>(ints);

        Map<String, Integer> aMap = new HashMap<>();
        aMap.put("1", 1);
        aMap.put("2", 2);
        aMap.put("3", 3);
        aMap.put("4", 4);
    }
}
