package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;

    @BeforeEach
    public void setup() {
        list = Arrays.asList(1, 4, 2);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);
        Assertions.assertEquals(7, sum); // 1 + 2 + 4 + 2 = 9
    }

    @Test
    public void max() {


        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);
        Assertions.assertEquals(1, min); // Valor mínimo na lista
    }

    @Test
    public void distinct() {
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

        // Set up the stub for deduplicate
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        // Create a ListAggregator instance and inject the mock deduplicator
        ListAggregator aggregator = new ListAggregator();


        // Perform the test
        int distinct = aggregator.distinct(Arrays.asList(1, 4, 2));

        // Assert the result
        Assertions.assertEquals(3, distinct);
    }
    public void max_bug_7263() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(-1, -4, -5));
        Assertions.assertEquals(-1, max); // Assuming the fixed max method returns -1 for the given list
    }

}
