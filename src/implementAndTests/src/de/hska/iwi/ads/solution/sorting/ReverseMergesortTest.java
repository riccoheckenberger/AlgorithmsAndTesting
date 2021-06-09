package de.hska.iwi.ads.solution.sorting;

public class ReverseMergesortTest <E extends Comparable<E>> extends AbstractMergesortTest{

    @Override
    public <E extends Comparable<E>> AbstractMergesortUniversal<E> createMergesort() {
        return new ReverseMergesort<>();
    }
}