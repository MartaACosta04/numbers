package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ListDeduplicatorTest implements GenericListDeduplicator {
    private List<Integer> list;
    private List<Integer> expected;
    private ListDeduplicator deduplicator;


    public List<Integer> deduplicate(List<Integer> list) {
        return Arrays.asList(1, 2, 4); // O stub sempre retorna este resultado
    }
}
