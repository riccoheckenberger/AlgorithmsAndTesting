package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractDictionary;
import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HashtableTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<>(10);
    }

    private Map<Integer, String> createHashtable() {
        Map<Integer, String> list = createMap();
        list.put(6, "Sechs");
        list.put(3, "Drei");
        list.put(1, "Eins");
        list.put(7, "Sieben");
        list.put(8, "Acht");
        list.put(4, "Vier");
        list.put(2, "Zwei");
        return list;
    }

    @Test
    void testNullValue() {
        Map<Integer, String> list = createHashtable();
        assertThrows(NullPointerException.class, () -> list.put(5, null));
        assertNull(list.get(5));
        assertThrows(NullPointerException.class, () -> list.put(1, null));
        assertEquals("Eins", list.get(1));
    }


    @Test
    void testPutGetSameKey() {
        Map<Integer, String> list = createHashtable();
        assertEquals(7, list.size());
        list.put(1, "N1");
        list.put(2, "N2");
        list.put(3, "N3");
        list.put(4, "N4");
        list.put(6, "N6");
        list.put(7, "N7");
        list.put(8, "N8");
        assertEquals(7, list.size());
        assertEquals("N1", list.get(1));
        assertEquals("N2", list.get(2));
        assertEquals("N3", list.get(3));
        assertEquals("N4", list.get(4));
        assertEquals("N6", list.get(6));
        assertEquals("N7", list.get(7));
        assertEquals("N8", list.get(8));
        assertEquals(7, list.size());
    }

    @Test
    void testFullList() {
        Map<Integer, String> list = createHashtable();
        list.put(5, "N5");
        list.put(9, "N9");
        list.put(10, "N10");
        assertThrows(AbstractDictionary.DictionaryFullException.class, () -> list.put(11, "N11"));
    }
}


