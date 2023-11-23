package com.aor.numbers;

import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ListAggregator {
    private GenericListDeduplicator deduplicator;


    public ListAggregator(GenericListDeduplicator deduplicator) {
        this.deduplicator = deduplicator;
    }

    public int distinct(List<Integer> list) {
        List<Integer> deduplicatedList = deduplicator.deduplicate(list);
        return deduplicatedList.size();
    }

    public int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (Integer number : list)
            if (number > max)
                max = number;
        return max;
    }

    public int min(List<Integer> list) {
        int min = Integer.MAX_VALUE;

        for (Integer number : list)
            if (number < min)
                min = number;
        return min;


    }
    public int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }



}
