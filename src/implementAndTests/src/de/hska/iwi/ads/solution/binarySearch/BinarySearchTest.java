package de.hska.iwi.ads.solution.binarySearch;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;

public class BinarySearchTest extends SearchTest  {

    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        return new BinarySearch<>();
    }

}
