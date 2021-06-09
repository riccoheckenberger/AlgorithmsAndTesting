package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;
import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

    public Hashtable(int capacity) {
        super(capacity);
    }

    @Override
    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        int currentHash = key.hashCode() % hashtable.length;
        Entry<K, V> entry = getEntry((K) key);
        return entry == null ? null : entry.getValue();
    }

    private Entry<K, V> getEntry(K key) {
        int currentHash = key.hashCode() % hashtable.length;
        for (int i = 0; i < hashtable.length; i++) {
            int currentIndex = (currentHash + i) % hashtable.length;

            if (hashtable[currentIndex] != null && hashtable[currentIndex].getKey().compareTo(key) == 0) {
                return hashtable[currentIndex];
            }
        }
        return null;
    }

    private int quadratischSondieren(int index) {
        int returnValue = 0;
        for (int i = 0; i < hashtable.length; i++) {
            int currentIndex = (index + i * i) % hashtable.length;
            if (hashtable[currentIndex] == null) {
                return currentIndex;
            }
        }
        throw new DictionaryFullException();
    }

    private int linearSondieren(int index) {
        int returnValue = 0;
        for (int i = 0; i < hashtable.length; i++) {
            int currentIndex = (index + i) % hashtable.length;
            if (hashtable[currentIndex] == null) {
                return currentIndex;
            }
        }
        throw new DictionaryFullException();
    }

    @Override
    public V put(K key, V value) {
        if (value == null || key == null) throw new NullPointerException();
        Entry<K, V> entry = this.getEntry(key);
        V returnValue = null;
        int putIndex;
        if (entry != null) {
            returnValue = entry.getValue();
            entry.setValue(value);
            return returnValue;
        } else {
            if (size == hashtable.length) throw new DictionaryFullException();
            int currentHash = key.hashCode() % hashtable.length;
            if (0.5 * hashtable.length <= size) {
                putIndex = quadratischSondieren(currentHash);
                hashtable[putIndex] = new SimpleEntry<>(key, value);
            } else {
                putIndex = linearSondieren(currentHash);
                hashtable[putIndex] = new SimpleEntry<>(key, value);
            }
            size++;
            return returnValue;
        }
    }
}
