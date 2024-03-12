package com.uvg.algoritmos;

import java.util.*;

public class MapFactory<K, V> {

    public Map<K, V> getMap(String mapType) {
        switch (mapType) {
            case "HashMap":
                return new HashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Unknown Map Type");
        }
    }
}
