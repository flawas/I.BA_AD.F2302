/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw10.sorting;

import java.util.Random;

public class SortUtils {

    public enum Order {
        ASCENDING, DESCENDING
    }

    public static final <T> boolean isSorted(Comparable<T> a[], Order order) {
        for (int i = 0; i < a.length - 1; i++) {
            Comparable<T> current = a[i];
            Comparable<T> next = a[i + 1];

            int result = current.compareTo((T) next); // Vergleichen des aktuellen Buchstabens mit dem nächsten
            switch (order) {
                case ASCENDING:
                    if (result > 0) { // wenn der nächste Buchstabe kleiner als der Vorgänger ist (result positiv)
                        return false; // abbruch, denn array ist falsch sortiert
                    } else {
                        break;
                    }
                case DESCENDING:
                    if (result < 0) { // wenn der nächste Buchstabe grösser als der Vorgänger ist (result negativ)
                        return false; // abbruch, denn array ist falsch sortiert
                    } else {
                        break;
                    }
            }
        }

        return true;
    }

    public static boolean isSorted(int[] array, Order order) {
        return isSorted(intArrayToInteger(array), order);
    }

    public static Integer[] intArrayToInteger(int[] intArray) {
        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = Integer.valueOf(intArray[i]);
        }
        return result;
    }

    public static final Character[] randomChars(final int length) {
        Random random = new Random();
        Character[] randomChar = new Character[length];
        for (int i = 0; i < length; i++) {
            randomChar[i] = (char) (random.nextInt(26) + 'a'); // speichert und generiert einen zufälligen Char-Wert
        }

        return randomChar;
    }

    public static final String[] randomStrings(final int length) {
        Random random = new Random();
        String[] randomString = new String[length];
        for (int i = 0; i < length; i++) {
            String tmp = (char) (random.nextInt(26) + 'a') + "" + (char) (random.nextInt(26) + 'a') + (char) (random.nextInt(26) + 'a') + (char) (random.nextInt(26) + 'a');
            randomString[i] = tmp; // speichert und generiert einen zufälligen String-Wert
        }

        return randomString;
    }

    public static final Integer[] randomIntegers(final int length) {
        Random random = new Random();
        Integer[] randomInteger = new Integer[length];
        for (int i = 0; i < length; i++) {
            randomInteger[i] = random.nextInt(length); // speichert und generiert einen zufälligen Char-Wert
        }

        return randomInteger;
    }

    public static final int[] randomInt(final int length) {
        Random random = new Random();
        int[] randomInteger = new int[length];
        for (int i = 0; i < length; i++) {
            randomInteger[i] = random.nextInt(length); // speichert und generiert einen zufälligen Char-Wert
        }

        return randomInteger;
    }
}
