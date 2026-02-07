package org.main.sorting;

public class HeapSort {
    private static void heapifyAscending(Comparable[] f, int idx, int last) {
        int i = idx;
        while (((2 * i) + 1) <= last) { // f[i] has a left child
            int j = (2 * i) + 1; // f[j] is left child of f[i]
            if (j + 1 <= last) { // if f[i] also has a right child
                if (f[j].compareTo(f[j+1]) > 0) { // Compare children: If left child is bigger than right child
                    j++; // j is now smaller
                }
            }
            if (f[i].compareTo(f[j]) > 0) { // if the parent is bigger than the child
                swap(f, i, j);
                i = j; // Continue swapping
            } else {
                break;
            }
        }
    }

    private static void swap(Comparable[] f, int i1, int i2) {
        Comparable tmp = f[i1];
        f[i1] = f[i2];
        f[i2] = tmp;
    }


    public static void sortAscending(Comparable[] f){
        for (int i = f.length / 2; i >= 0; i--) {
            heapifyAscending(f, i, f.length - 1);
        }

        for (int i = f.length - 1; i > 0; i--) {
            swap(f, 0, i);
            heapifyAscending(f, 0, i - 1);
        }
    }
}
