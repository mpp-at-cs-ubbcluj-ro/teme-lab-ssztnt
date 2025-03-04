package org.example;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testCountObjectsInTuple() {
        Pair<String, Integer> pair = Pair.of("example", 42);
        int count = Main.countObjectsInTuple(pair);
        assertEquals(2, count, "The count of objects in the tuple should be 2");
    }

    @Test
    public void testTrimmedMessage() {
        String message = " Hello and welcome! ";
        String trimmedMessage = org.apache.commons.lang3.StringUtils.trim(message);
        assertEquals("Hello and welcome!", trimmedMessage, "The trimmed message should be 'Hello and welcome!'");
    }
}