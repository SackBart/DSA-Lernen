package org.main.trees;

import java.util.Set;

public class TreeSet<K extends Comparable<K>>{
    private RedBlackTree<K> tree;

    public TreeSet() {
        tree = new RedBlackTree<>();
    }

    public int size() {
        return tree.size();
    }

    public boolean add(K k) {
        return tree.insert(k);
    }

    public boolean contains(K k) {
        return tree.contains(k);
    }
}
