package org.main.sorting;

import java.util.Collections;
import java.util.List;

/**
 * Bubble race: Bubbles inside a fluid where the bigger bubbles "overtake" the smaller ones
 */

public class BubbleSort implements SortInterface{
    private BubbleSort() {
        throw new AssertionError();
    }

    /**
     * Sorts the integers inside the array list using selection sort in ascending order
     * @param list the list to sort
     * @return the same list but sorted
     */
    public static List<Integer> sortAscending(List<Integer> list){
        int j = list.size() - 1; // is the upper bound for the iteration (dynamic)

        while (j > 0){
            boolean swapped = false;
            // Iterate from the beginning to the upper bound
            for (int i = 0; i < j; i++){
                if (list.get(i) > list.get(i + 1)){ // if the right one is smaller than the left then swap
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped){ // if nothing has been swapped in this iteration then everything is already sorted
                break;
            }
            j -= 1; // decrease the upper bound by one
        }

        return list;
    }

    /**
     * Sorts the integers inside the array list using selection sort in descending order
     * @param list the list to sort
     * @return the same list but sorted
     */
    public static List<Integer> sortDescending(List<Integer> list){
        int j = list.size() - 1; // is the upper bound for the iteration (dynamic)

        while (j > 0){
            boolean swapped = false;
            // Iterate from the beginning to the upper bound
            for (int i = 0; i < j; i++){
                if (list.get(i) < list.get(i + 1)){ // if the right one is bigger than the left then swap (difference: "<" instead of ">")
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped){ // if nothing has been swapped in this iteration then everything is already sorted
                break;
            }
            j -= 1; // decrease the upper bound by one
        }

        return list;
    }
}
