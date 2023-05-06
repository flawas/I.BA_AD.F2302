/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw10.quicksort;

public class QuickSort {

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left;
        int down = right - 1;
        char t = a[right];
        boolean allChecked = false; do {
            while (a[up] < t) {
            up++;
            // linke Grenze
            // rechte Grenze (ohne Trennelement) // rechtes Element als Trennelement
            // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++; down--; } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }
}
