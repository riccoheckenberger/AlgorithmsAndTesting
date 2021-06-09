package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;

import de.hska.iwi.ads.interfaces.Vector;
import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.sorting.Sort;
import org.junit.jupiter.api.Test;

public abstract class AbstractMergesortTest {

    public abstract <E extends Comparable<E>> AbstractMergesortUniversal<E> createMergesort();

    @Test
    void testIntegerSort1() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {11, 10, 9, 7, 4, 2, 0};
        Integer[] ergebnis = {0, 2, 4, 7, 9, 10, 11};
        sortObject.sort(a);
        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSort2() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] ergebnis = {1, 2, 3, 4, 5, 6, 7, 8};
        sortObject.sort(a);
        assertArrayEquals(a, ergebnis);

    }

    @Test
    void testIntegerPosition1() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {2, 0, 4, 7, 9, 10, 11};
        sortObject.sort(a);
        assertEquals(2, a[1]);
    }

    @Test
    void testIntegerPosition2() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {2, 2, 2, 2, 2, 2, 1};
        sortObject.sort(a);
        assertEquals(1, a[0]);
    }

    @Test
    void testStability1() {
        StabilityCheck number1 = new StabilityCheck(1, 1);
        StabilityCheck number2 = new StabilityCheck(1, 2);
        StabilityCheck number3 = new StabilityCheck(1, 3);
        StabilityCheck number4 = new StabilityCheck(1, 4);
        StabilityCheck number5 = new StabilityCheck(1, 5);

        AbstractMergesortUniversal<StabilityCheck> testObject = createMergesort();
        StabilityCheck[] a = {number1, number2, number3, number4, number5};
        StabilityCheck[] ergebnis = {number1, number2, number3, number4, number5};
        testObject.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
        assertEquals(1, a[0].getId());
        assertEquals(2, a[1].getId());
        assertEquals(3, a[2].getId());
        assertEquals(4, a[3].getId());
        assertEquals(5, a[4].getId());

    }

    @Test
    void testStability2() {
        StabilityCheck number1 = new StabilityCheck(1, 1);
        StabilityCheck number2 = new StabilityCheck(2, 2);
        StabilityCheck number3 = new StabilityCheck(1, 3);
        StabilityCheck number4 = new StabilityCheck(3, 4);
        StabilityCheck number5 = new StabilityCheck(2, 5);

        AbstractMergesortUniversal<StabilityCheck> testObject = createMergesort();
        StabilityCheck[] a = {number1, number2, number3, number4, number5};
        StabilityCheck[] ergebnis = {number1, number3, number2, number5, number4};
        testObject.sort(a);

        assertTrue(arrayEquals(ergebnis, a));
        assertEquals(1, a[0].getId());
        assertEquals(3, a[1].getId());
        assertEquals(2, a[2].getId());
        assertEquals(4, a[4].getId());
        assertEquals(5, a[3].getId());

    }

    @Test
    void testStringSort2() {
        AbstractMergesortUniversal<String> sortObject = createMergesort();
        String[] a = {"black", "over", "a", "utah", "to", "car", "public", "roads", "moving"};
        String[] ergebnis = {"a", "black", "car", "moving", "over", "public", "roads", "to", "utah"};
        sortObject.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSortEmpty() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {};
        Integer[] ergebnis = {};
        sortObject.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSortEmpty() {
        AbstractMergesortUniversal<String> sortObject = createMergesort();
        String[] a = {};
        String[] ergebnis = {};
        sortObject.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerSortOneElement() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = {0};
        Integer[] ergebnis = {0};
        sortObject.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testStringSortOneElement() {
        AbstractMergesortUniversal<String> sortObject = createMergesort();
        String[] a = {"OneString"};
        String[] ergebnis = {"OneString"};
        sortObject.sort(a);

        assertArrayEquals(ergebnis, a);
    }

    @Test
    void testIntegerZeitaufwand() {
        AbstractMergesortUniversal<Integer> sortObject = createMergesort();
        Integer[] a = new Integer[100000];
        java.util.Arrays.fill(a, 0);
        sortObject.sort(a);

    }


    boolean arrayEquals(Comparable[] e, Comparable[] a) {
        boolean equals = true;
        if (e.length != a.length) {
            equals = false;
        }
        for (int i = 0; i < e.length; i++) {
            if (a[i].compareTo(e[i]) != 0) {
                equals = false;
            }
        }
        return equals;
    }

}