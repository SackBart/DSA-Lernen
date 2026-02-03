package org.main.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortInterface{
    private MergeSort() {
        throw new AssertionError();
    }

    private static List<Integer> mergeDescending(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();

        // Run until one of the lists is empty (If one is empty, then we can't compare anymore)
        while (!(list1.isEmpty() || list2.isEmpty())) {
            if (list1.getFirst() < list2.getFirst()) { // first element from list1 is smaller so add the first element from list2 to the new list (l.12)
                list.add(list2.getFirst());
                list2.removeFirst();
            } else { // first element from list2 is smaller so add the first element from list1 to the new list (l.12)
                list.add(list1.getFirst());
                list1.removeFirst();
            }
        }

        // Either list1 or list2 is empty so put the rest at the end if there are any elements
        while (!list1.isEmpty()) {
            list.add(list1.removeFirst());
        }
        while (!list2.isEmpty()) {
            list.add(list2.removeFirst());
        }

        return list;
    }


    private static List<Integer> mergeAscending(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();

        // Run until one of the lists is empty (If one is empty, then we can't compare anymore)
        while (!(list1.isEmpty() || list2.isEmpty())) {
            if (list1.getFirst() > list2.getFirst()) { // first element from list1 is bigger so add the first element from list2
                list.add(list2.getFirst());
                list2.removeFirst();
            } else { // first element from list2 is bigger so add the first element from list1
                list.add(list1.getFirst());
                list1.removeFirst();
            }
        }

        // Either list1 or list2 is empty so put the rest at the end if there are any elements
        while (!list1.isEmpty()) {
            list.add(list1.removeFirst());
        }
        while (!list2.isEmpty()) {
            list.add(list2.removeFirst());
        }

        return list;
    }

    /**
     * Sorts the integers inside the array list using selection sort in ascending order
     * @param list the list to sort
     * @return a new list which is sorted
     */
    public static List<Integer> sortAscending(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        } else {
            // Init
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            // Split list in list1 (1st half of list) and list2 (2nd half of list)
            for (int i = 0; i < list.size() / 2; i++) {
                list1.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                list2.add(list.get(i));
            }

            list1 = sortAscending(list1);
            list2 = sortAscending(list2);

            return mergeAscending(list1, list2);
        }
    }

    /**
     * Sorts the integers inside the array list using selection sort in descending order
     * @param list the list to sort
     * @return a new list which is sorted
     */
    public static List<Integer> sortDescending(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        } else {
            // Init
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            // Split list in list1 (1st half of list) and list2 (2nd half of list)
            for (int i = 0; i < list.size() / 2; i++) {
                list1.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                list2.add(list.get(i));
            }

            list1 = sortDescending(list1);
            list2 = sortDescending(list2);

            return mergeDescending(list1, list2);
        }
    }
}
