package org.main.trees;

import org.main.trees.nodes.BTreeNode;

public class BTree<T extends Comparable<T>> {
    private int order;
    private BTreeNode<T> root;

    public BTree(int order) {
        this.order = order;
        root = null;
    }
}
