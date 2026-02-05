package org.main.examples.trees;

import org.main.trees.AVLTree;
import org.main.trees.RedBlackTree;
import org.main.trees.util.RedBlackTreePrinter;

import java.util.Random;

public class TreeMaker {
    public static void main(String[] args){
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int number = rand.nextInt(20);
            tree.insert(number);
            System.out.println("Inserted " + number);
            RedBlackTreePrinter.printNode(tree.getRoot());
        }

        RedBlackTreePrinter.printNode(tree.getRoot());
    }
}
