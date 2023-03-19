/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableBuckets;

import ch.hslu.ad.sw04.stackImplementation.StackElement;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableItemTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(HashTableItem.class).verify();
    }

}