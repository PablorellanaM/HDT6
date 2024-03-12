package com.uvg.algoritmos;

import org.junit.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import static org.junit.Assert.*;

public class MapFactoryTest {

    @Test
    public void testGetHashMap() {
        MapFactory<String, String> mapFactory = new MapFactory<>();
        assertTrue(mapFactory.getMap("HashMap") instanceof HashMap);
    }

    @Test
    public void testGetTreeMap() {
        MapFactory<String, String> mapFactory = new MapFactory<>();
        assertTrue(mapFactory.getMap("TreeMap") instanceof TreeMap);
    }

    @Test
    public void testGetLinkedHashMap() {
        MapFactory<String, String> mapFactory = new MapFactory<>();
        assertTrue(mapFactory.getMap("LinkedHashMap") instanceof LinkedHashMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMapWithInvalidType() {
        MapFactory<String, String> mapFactory = new MapFactory<>();
        mapFactory.getMap("NonExistentMap");
    }
}
