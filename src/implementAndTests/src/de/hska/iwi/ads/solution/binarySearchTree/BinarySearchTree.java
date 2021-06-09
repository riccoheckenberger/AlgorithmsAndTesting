package de.hska.iwi.ads.solution.binarySearchTree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

    public BinarySearchTree() {
        super();
    }

    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        Node node = getEntry(this.root, (K) key);
        return node == null ? null : node.entry.getValue();
    }

    public V put(K key, V value) {
        if (value == null || key == null) throw new NullPointerException();
        Node y = null;
        Node x = this.root;
        V returnValue;
        while (x != null) {
            if (key.compareTo(x.entry.getKey()) == 0) {
                returnValue = x.entry.getValue();
                x.entry.setValue(value);
                return returnValue;
            }
            y = x;
            if (key.compareTo(x.entry.getKey()) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        if (y == null) {
            this.root = new Node(key, value);
        } else if (key.compareTo(y.entry.getKey()) < 0) {
            y.left = new Node(key, value);
        } else {
            y.right = new Node(key, value);
        }
        size++;
        return value;
    }

    public Node getEntry(Node x, K key) {
        if (x == null || x.entry.getKey() == key) {
            return x == null ? null : x;
        } else if (key.compareTo(x.entry.getKey()) < 0) {
            return getEntry(x.left, key);
        } else return getEntry(x.right, key);
    }
}
