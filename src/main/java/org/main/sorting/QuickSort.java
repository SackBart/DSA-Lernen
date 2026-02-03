package org.main.sorting;

import java.util.Collections;
import java.util.List;

/**
 * Having a pivot as a comparison. E.g. Ascending sorting:
 *
 * Anything that's bigger than the pivot is on the right of the pivot and anything lower than the pivot is on the left.
 * Use split-and-conquer method to sort individual values until it's fully sorted
 */

public class QuickSort implements SortInterface{
    private QuickSort(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static Integer splitDescending(List<Integer> list, int lowerBound, int upperBound, int pivot){
        int p_n = lowerBound;
        int p_v = list.get(pivot);

        // put the pivot in the end
        Collections.swap(list, pivot, upperBound);

        // go through the list
        for (int i = lowerBound; i < upperBound; i++) {
            // if the value at index i is greater than the pivots value, swap its position to p_n and increase p_n afterwards
            if (list.get(i) > p_v) {
                Collections.swap(list, p_n, i);
                p_n += 1;
            }
        }

        // put the pivot to its new position
        Collections.swap(list, upperBound, p_n);

        return p_n;
    }

    /**
     * Sorts the integers inside the array list using selection sort in ascending order
     * @param list the list to sort
     * @return the same list which is sorted
     */
    private static Integer splitAscending(List<Integer> list, int lowerBound, int upperBound, int pivot){
        int p_n = lowerBound;
        int p_v = list.get(pivot);

        // put the pivot in the end
        Collections.swap(list, pivot, upperBound);

        // go through the list
        for (int i = lowerBound; i < upperBound; i++) {
            // if the value at index i is less than the pivots value, swap its position to p_n and increase p_n afterwards
            if (list.get(i) < p_v) {
                Collections.swap(list, p_n, i);
                p_n += 1;
            }
        }

        // put the pivot to its new position
        Collections.swap(list, upperBound, p_n);

        return p_n;
    }

    public static List<Integer> sortAscending(List<Integer> list, int lowerBound, int upperBound){
        if (upperBound > lowerBound) {
            int p = lowerBound;
            int p_n = splitAscending(list, lowerBound, upperBound, p); // get the new pivots index

            // sort the subsets (left subset of pivot and right subset of pivot)
            sortAscending(list, lowerBound, p_n - 1);
            sortAscending(list, p_n + 1, upperBound);
        }

        return list;
    }

    /**
     * Sorts the integers inside the array list using selection sort in descending order
     * @param list the list to sort
     * @return the same list which is sorted
     */
    public static List<Integer> sortDescending(List<Integer> list, int lowerBound, int upperBound){
        if (upperBound > lowerBound) {
            int p = lowerBound;
            int p_n = splitDescending(list, lowerBound, upperBound, p); // get the new pivots index

            // sort the subsets (left subset of pivot and right subset of pivot)
            sortDescending(list, lowerBound, p_n - 1);
            sortDescending(list, p_n + 1, upperBound);
        }

        return list;
    }
}
