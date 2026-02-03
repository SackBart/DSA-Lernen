package org.main.sorting;

import java.util.Collections;
import java.util.List;

/**
 * Ascending:
 * SelectionSort starts with the whole Array then gets the biggest number and decreases the field by one size (right to left)
 * until the size is 0
 *
 * Descending:
 * Same with Ascending, but it searches for the lowest number
 */

public class SelectionSort implements SortInterface {
    private SelectionSort() {
        throw new AssertionError();
    }

    /**
     * Sorts the integers inside the array list using selection sort in ascending order
     * @param list the list to sort
     * @return the same list but sorted
     */
    public static List<Integer> sortAscending(final List<Integer> list) {
        int p = list.size() - 1;

        while (p > 0) {
            // Get the index with the highest value inside the current field
            int currentHighestIndex = 0;
            for (int i = 0; i <= p; i++) {
                if (list.get(currentHighestIndex) < list.get(i)) {
                    currentHighestIndex =  i;
                }
            }

            // Switch the index with the highest value on the highest current index
            Collections.swap(list, p, currentHighestIndex);

            // Decrease the field
            p -= 1;
        }

        return list;
    }

    /**
     * Sorts the integers inside the array list using selection sort in descending order
     * @param list the list to sort
     * @return the same list but sorted
     */
    public static List<Integer> sortDescending(final List<Integer> list) {
        int p = list.size() - 1;

        while (p > 0) {
            // Get the index with the lowest value inside the current field
            int currentHighestIndex = 0;
            for (int i = 0; i <= p; i++) {
                if (list.get(currentHighestIndex) > list.get(i)) { // now it's > instead of <
                    currentHighestIndex =  i;
                }
            }

            // Switch the index with the lowest value with the current highest index
            Collections.swap(list, p, currentHighestIndex);

            // Decrease the field
            p -= 1;
        }

        return list;
    }
}
