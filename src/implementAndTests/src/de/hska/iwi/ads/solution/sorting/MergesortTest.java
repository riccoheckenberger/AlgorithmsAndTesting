package de.hska.iwi.ads.solution.sorting;

import org.junit.jupiter.api.Test;

public class MergesortTest <E extends Comparable<E>> extends AbstractMergesortTest{

    @Override
    public <E extends Comparable<E>> AbstractMergesortUniversal<E> createMergesort() {
       return new Mergesort<E>();
    }
}
