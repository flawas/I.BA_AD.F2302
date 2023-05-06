/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw10.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortUtilsTest {

    private Character[] charArraySorted;
    private Character[] charArrayReverseSorted;
    private Character[] charArrayRandom;

    @Before
    public void setup() {
        charArraySorted = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        charArrayReverseSorted = new Character[]{'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        charArrayRandom = new Character[]{'d', 'a', 'c', 'f', 'b', 'g', 'e'};
    }

    @Test
    public void testIsSortedArrayAscending() {
        assertTrue(SortUtils.isSorted(charArraySorted, SortUtils.Order.ASCENDING));
        assertFalse(SortUtils.isSorted(charArrayReverseSorted, SortUtils.Order.ASCENDING));
        assertFalse(SortUtils.isSorted(charArrayRandom, SortUtils.Order.ASCENDING));
    }

    @Test
    public void testIsSortedArrayDescending() {
        assertTrue(SortUtils.isSorted(charArrayReverseSorted, SortUtils.Order.DESCENDING));
        assertFalse(SortUtils.isSorted(charArraySorted, SortUtils.Order.DESCENDING));
        assertFalse(SortUtils.isSorted(charArrayRandom, SortUtils.Order.DESCENDING));
    }
}