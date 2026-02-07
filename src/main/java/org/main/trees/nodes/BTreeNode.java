package org.main.trees.nodes;

public class BTreeNode<K extends Comparable<K>> {
    private K[] keys;
    private BTreeNode<K>[] children;

    public BTreeNode(final int order) {
        keys = (K[]) new Object[2 * order];
        children = (BTreeNode<K>[]) new Object[2 * order + 1];
    }

    public K getKey(final int i) {
        return keys[i];
    }

    public void setKey(final int i, final K key) {
        keys[i] = key;
    }

    public BTreeNode<K> getChild(final int i) {
        return children[i];
    }

    public void setChild(final int i, final BTreeNode<K> node) {
        children[i] = node;
    }

    public boolean find(K key){
        for (int i = 0; i < children.length; i++){
            if (i == keys.length || keys[i] == null) {
                /*
                    Node doesn't contain any more elements
                    Find the node on the last subtree
                 */
                if (children[i] != null){
                    return children[i].find(key);
                }
                return false; // The node is a leaf node (no children)
            }
            int cmp = keys[i].compareTo(key);
            if (cmp == 0) {
                return true; // Found key
            } else if (cmp > 0) { // Key inside the node is bigger than the key to search
                /*
                    We have to continue searching on the left subtree
                 */
                if (children[i] != null){
                    return children[i].find(key);
                }
                return false; // The node is a leaf node (no children)
            }
        }
        return false;
    }
}
