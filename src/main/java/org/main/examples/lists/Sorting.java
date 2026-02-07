package org.main.examples.lists;

import org.main.sorting.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        Random r = new Random();
        int amount = 100;
        Integer[] list = new Integer[amount];

        for (int i = 0; i < amount; i++) {
            list[i] = r.nextInt(100);
        }

        System.out.println("Unsorted: " + Arrays.toString(list));
        HeapSort.sortAscending(list);
        System.out.println("Sorted: " + Arrays.toString(list));
    }
}
