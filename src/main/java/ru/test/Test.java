package ru.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(check(List.of(0, 0, 0, 0)));
        System.out.println(check(List.of(1, 1)));
        System.out.println(check(List.of(6, 6)));
        System.out.println(check(List.of(2, 2, 2, 1)));
        System.out.println(modify(List.of(1,2,1,2,2)));
    }
    public static boolean check(List<Integer> array) {
        Map<Integer, Boolean> check = new HashMap<>();
        check.put(1, false);
        check.put(2, false);
        check.put(null, true);
        boolean result = false;

        for (Integer integer : array) {
            if (check.containsKey(integer) && !check.get(integer)) {
                check.put(integer, true);
            } else if (!check.containsKey(integer)) {
                check.put(null, false);
            }
        }
        System.out.println(check);

        if (check.containsValue(false)) {
            return false;
        }
        return true;
    }

    public static List<Integer> modify(List<Integer> array) {
        List<Integer> newArr = new ArrayList<>();

        int index = -1;
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) == 1) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new RuntimeException();
        }

        for (int i = index + 1; i < array.size(); i++) {
            newArr.add(array.get(i));
        }

        return newArr;
    }

}
