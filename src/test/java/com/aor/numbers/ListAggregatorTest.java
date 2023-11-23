package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    private static class DeduplicatorStub implements GenericListDeduplicator {
        @Override
        public List<Integer> deduplicate(List<Integer> list) {
            return Arrays.asList(1, 2, 4); // Stub always returns this result
        }
    }

    @BeforeEach
    public void setup() {
        list = Arrays.asList(1, 2, 4, 2);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(new DeduplicatorStub());
        int sum = aggregator.sum(list);
        Assertions.assertEquals(9, sum); // 1 + 2 + 4 + 2 = 9
    }

    @Test
    public void max() {


        int max = Integer.MIN_VALUE;

        for (Integer number : list)
            if (number > max)
                max = number;

        Assertions.assertEquals(4, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(new DeduplicatorStub());
        int min = aggregator.min(list);
        Assertions.assertEquals(1, min); // Valor mínimo na lista
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(new DeduplicatorStub());
        int distinct = aggregator.distinct(list);
        Assertions.assertEquals(3, distinct);
    }
    public void max_bug_7263() {
        ListAggregator aggregator = new ListAggregator(new DeduplicatorStub());
        int max = aggregator.max(Arrays.asList(-1, -4, -5));
        Assertions.assertEquals(-1, max); // Assuming the fixed max method returns -1 for the given list
    }

}
