package org.main.examples.lists;

import org.main.sorting.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int random = r.nextInt(100);

            list.add(random);
        }

        System.out.println("List: " + list);
        System.out.println("Sorted List: " + QuickSort.sortDescending(list, 0, list.size()-1));
    }
}
