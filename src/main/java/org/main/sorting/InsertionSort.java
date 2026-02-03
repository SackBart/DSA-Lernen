package org.main.sorting;

import java.util.Collections;
import java.util.List;

/**
 * InsertionSort acts like sorting cards. For example, the lowest are on the highest position. When you find a small value on the bottom position,
 * you look at the other cards and put it on the right place (higherCard <= sortedCard <= lowerCard)
 */

public class InsertionSort implements SortInterface {
    private InsertionSort() {
        throw new AssertionError();
    }

    /**
     * Sorts the integers inside the array list using selection sort in ascending order
     * @param list the list to sort
     * @return the same list but sorted
     */
    public static List<Integer> sortAscending(List<Integer> list) {
        // Iterate through the whole list (except for index 0)
        for (int i = 1; i < list.size(); i++) {
            // j will be the subset to look after. Anything above j won't be compared
            int value = list.get(i);
            int j = i;

            while (j > 0) {
                // If the value with the lower index than the value is bigger, then move the value (l.17)
                // then swap so the value (l.17) is on the left
                // otherwise the value (l.17) is on the right place
                if (list.get(j - 1) > value) {
                    // Move the value on j - 1 to the right
                    Collections.swap(list, j - 1, j);
                    j -= 1;
                } else {
                    break;
                }
            }
            list.set(j, value);
        }

        return list;
    }

    /**
     * Sorts the integers inside the array list using selection sort in descending order
     * @param list the list to sort
     * @return the same list but sorted
     */
    public static List<Integer> sortDescending(List<Integer> list) {
        // Iterate through the whole list (except for index 0)
        for (int i = 1; i < list.size(); i++) {
            // j will be the subset to look after. Anything above j won't be compared
            int value = list.get(i);
            int j = i;

            while (j > 0) {
                // If the value with the lower index than the value is lower, then move the value (l.17)
                // then swap so the value (l.17) is on the left
                // otherwise the value (l.17) is on the right place
                if (list.get(j - 1) < value) { // here's the difference ("<" instead of ">")
                    // Move the value on j - 1 to the right
                    Collections.swap(list, j - 1, j);
                    j -= 1;
                } else {
                    break;
                }
            }
            list.set(j, value);
        }

        return list;
    }
}
