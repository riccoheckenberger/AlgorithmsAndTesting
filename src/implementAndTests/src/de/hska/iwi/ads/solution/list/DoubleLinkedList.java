package de.hska.iwi.ads.solution.list;
import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {

    /**
     * This getter-method iterates through the EntrySet and searches for the corresponding key in the parameters.
     * In case of a match, the matching value is to be returned. In case of a no-match scenario, the return value is null.
     *
     * @param key - the key on which the search is based upon
     * @return The mapped value to the key in case of a match. Other than that, the return value will be null.
     */

    @SuppressWarnings("Unchecked")
    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        Entry<K, V> entry = getEntry((K) key);
        return entry == null ? null : entry.getValue();
    }


    /**
     * Addition of a new element at the top of the linked list in case the key is not yet implemented in the list
     *
     * @param key   - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */

    public V put(K key, V value) {
        if (key == null || value == null) {throw new NullPointerException();}
        Entry<K, V> newEntry = getEntry(key);
        V valueReturn;
        if (newEntry != null) {
            valueReturn = newEntry.getValue();
            newEntry.setValue(value);
        } else {
            Entry<K, V> startEntry = new SimpleEntry (key, value);
            ListElement headerElement = new ListElement(startEntry, null, head);
            if (size != 0) {
                head.previous = headerElement;}
                head = headerElement;
            valueReturn = null;
            size++;
        }
        return valueReturn;
    }

    /**
     * Iterating through the linkedList and searching for the corresponding key.
     * The starting point is the head of the list and the method iterates through the list,
     * whilst returning the matching key or null in case of a no-match scenario.
     *
     * @param key - the key which is matched against the entries
     * @return entry - the entry contains the key and the value
     */

    private Entry<K, V> getEntry(K key) {
        if (size > 0) {
            for (ListElement currentElement = head; currentElement != null; currentElement = currentElement.next) {
                if (currentElement.entry.getKey().compareTo(key) == 0) {
                    return currentElement.entry;
                }
            }
        }
        return null;
    }
}


