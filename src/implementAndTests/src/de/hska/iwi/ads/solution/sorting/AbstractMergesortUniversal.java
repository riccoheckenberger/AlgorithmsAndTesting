package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public abstract class AbstractMergesortUniversal <E extends Comparable<E>> extends AbstractMergesort<E> {

    abstract void fusion (E[] a, int left, int m, int right);

    @Override
    protected void mergesort(E[] a, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            mergesort(a, left, m);
            mergesort(a, m + 1, right);
            fusion(a, left, m, right);
        }
    }}
