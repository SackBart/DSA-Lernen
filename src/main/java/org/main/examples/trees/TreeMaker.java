package org.main.examples.trees;

import org.main.trees.BinarySearchTree;
import org.main.trees.util.BTreePrinter;

import java.util.Random;

public class TreeMaker {
    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            tree.insert(rand.nextInt(20));
        }

        BTreePrinter.printNode(tree.getRoot());
    }
}
