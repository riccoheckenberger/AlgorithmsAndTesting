package de.hska.iwi.ads.solution.binarySearch;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable <E>> implements Search<E> {

    private int binarySearch(E[] a, E key, int left, int right) {
        if (right < left) {
                return right + 1;
        } else {
            int middle = (left + right) / 2;
            if (key.compareTo(a[middle]) == 0) {
                return binarySearch(a,key,left,middle-1);
            } else if (key.compareTo(a[middle]) < 0) {
                return binarySearch(a, key, left, middle - 1);
            } else return binarySearch(a, key, middle + 1, right);
        }
    }

    @Override
    public int search(E[] a, E key, int left, int right) {
        int i;
        if (key.compareTo(a[left]) < 0) {
            i = left - 1;
        } else if (key.compareTo(a[right]) > 0) {
            i = right + 1;
        } else {
            i = this.binarySearch(a, key, left, right);
        }
        return i;
    }
}


