/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.stackImplementation;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

public class StackElement {

    private final String data;
    public StackElement(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "StackElement{" +
                "data='" + data + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StackElement that)) return false;

        return Objects.equals(data, that.data);
    }

    @Override
    public final int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
