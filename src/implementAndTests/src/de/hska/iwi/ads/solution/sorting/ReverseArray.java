package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

    @Override
    public void reverse(E[] a, int from, int to) {
        E b;
        for (; from <=  to; from++, to--) {
            b = a[from];
            a[from] = a[to];
            a[to] = b;
        }
    }
}


