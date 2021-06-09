package de.hska.iwi.ads.solution.binarySearchTree;

import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest extends MapTest {
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new BinarySearchTree<>();
    }


    @Test
    void testNullValue() {
        Map<Integer, String> tree = createMap();
        assertThrows(NullPointerException.class, () -> tree.put(5, null));
        assertNull(tree.get(5));
        assertThrows(NullPointerException.class, () -> tree.put(1, null));
        assertNull(tree.get(1));
    }

    @Test
    void testNullKey() {
        Map<Integer, String> tree = createMap();
        assertThrows(NullPointerException.class, () -> tree.put(null, "1"));
        assertThrows(NullPointerException.class, () -> tree.get(null));
        assertThrows(NullPointerException.class, () -> tree.put(null, "2"));
    }

    @Test
    void testPutGetSameKey () {
        Map<Integer, String> tree = createMap();
        tree.put(1, "N1");
        tree.put(2, "N2");
        tree.put(3, "N3");
        tree.put(4, "N4");
        assertEquals(4, tree.size());
        tree.put(1, "O1");
        tree.put(2, "O2");
        tree.put(3, "O3");
        assertEquals(4, tree.size());
        assertEquals("O1", tree.get(1));
        assertEquals("O2", tree.get(2));
        assertEquals("O3", tree.get(3));
        assertEquals("N4", tree.get(4));
        assertEquals(4, tree.size());
    }

}