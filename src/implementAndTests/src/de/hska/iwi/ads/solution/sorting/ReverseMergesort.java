package de.hska.iwi.ads.solution.sorting;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesortUniversal<E> {

    @Override
    void fusion(E[] a, int left, int m, int right) {
        int l = left;
        int r = right;

        ReverseArray<E> reverse = new ReverseArray<E>();
        reverse.reverse(a, m + 1, right);
        for (int i = left; i <= right; i++) {
            if (a[l].compareTo(a[r]) <= 0) {
                b[i] = a[l];
                l++;
            } else {
                b[i] = a[r];
                r--;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}

