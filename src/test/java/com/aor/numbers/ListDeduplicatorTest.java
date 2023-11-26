package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;
    private GenericListDeduplicator deduplicator;

    @BeforeEach
    public void setup() {
        list = Arrays.asList(1, 2, 3, 2, 4);
        expected = Arrays.asList(1, 2, 3, 4);
        deduplicator = Mockito.mock(GenericListDeduplicator.class);

        // Set up the stub
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(expected);
    }

    @Test
    public void deduplicate() {
        // Use the deduplicator stub
        List<Integer> result = deduplicator.deduplicate(list);

        // Perform the test
        Assertions.assertEquals(expected, result);
    }
}