package org.main.sorting;

/**
 * HeapSort uses Heaps to sort Arrays. Heaps have the property that every node is bigger/smaller than its children.
 * MaxHeap: Node is bigger than its children
 * MinHeap: Node is smaller than its children
 *
 * A heap is a binary tree but not a searching tree
 * since it does not follow the rule that the right child is bigger than its parent.
 *
 * The given Array is the level-order of a heap
 *
 * To get the left child of an index i, calculate (i * 2) + 1
 * To get the right child of an index i, calculate (i * 2) + 2
 * To get the parent of a node with index i, calculate math.floor((i - 1)/2)
 *
 * Heap: https://www.geeksforgeeks.org/dsa/heap-data-structure/
 * HeapSort: https://www.geeksforgeeks.org/dsa/heap-sort/
 */
public class HeapSort {
    private static void heapifyDescending(Comparable[] f, int idx, int last) {
        int i = idx;
        while (((2 * i) + 1) <= last) { // f[i] has a left child
            int j = (2 * i) + 1; // f[j] is left child of f[i]
            if (j + 1 <= last) { // if f[i] also has a right child
                if (f[j].compareTo(f[j+1]) > 0) { // Compare children: If left child is bigger than right child
                    j++; // then choose the one that's smaller (Right one)
                }
            }
            if (f[i].compareTo(f[j]) > 0) { // if the parent is bigger than the child
                swap(f, i, j); // swap the smallest child with the parent
                i = j; // the new index is the left/right child or new node
            } else {
                break;
            }
        }
    }

    private static void heapifyAscending(Comparable[] f, int idx, int last) {
        int i = idx;
        while (((2 * i) + 1) <= last) { // f[i] has a left child
            int j = (2 * i) + 1; // f[j] is left child of f[i]
            if (j + 1 <= last) { // if f[i] also has a right child
                if (f[j].compareTo(f[j+1]) < 0) { // Compare children: If left child is smaller than right child
                    j++; // then choose the one that's bigger (Right one)
                }
            }
            if (f[i].compareTo(f[j]) < 0) { // if the parent is smaller than the child
                swap(f, i, j); // swap the biggest child with the parent
                i = j; // the new index is the left/right child or new node
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


    public static void sortDescending(Comparable[] f){
        for (int i = f.length / 2; i >= 0; i--) { // Go through all nodes except for the leafs (Nodes start at f.length/2 + 1)
            heapifyDescending(f, i, f.length - 1);
        }

        for (int i = f.length - 1; i > 0; i--) {
            swap(f, 0, i);
            heapifyDescending(f, 0, i - 1);
        }
    }

    public static void sortAscending(Comparable[] f){
        for (int i = f.length / 2; i >= 0; i--) { // Go through all nodes except for the leafs (Nodes start at f.length/2 + 1)
            /*
                At the first iteration the leafs will be compared (Last inner node with leaf nodes as its children)
                Then the more inner nodes until it reaches the root (index 0)
             */
            heapifyAscending(f, i, f.length - 1);
        }

        /*
            Swap the biggest number on the last place
         */
        for (int i = f.length - 1; i > 0; i--) {
            swap(f, 0, i); // swap the biggest number on the last available space
            heapifyAscending(f, 0, i - 1); // sort the root
        }
    }
}
