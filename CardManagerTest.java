package com.uvg.algoritmos;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CardManagerTest {
    private CardManager cardManager;
    private Map<String, String> cardMap;

    @Before
    public void setUp() {
        cardMap = new HashMap<>();
        cardMap.put("Dragon", "Creature");
        cardMap.put("Fireball", "Spell");
        cardManager = new CardManager(cardMap);
    }

    @Test
    public void testAddCardToUserCollection() {
        assertTrue(cardManager.addCardToUserCollection("Dragon"));
        assertFalse(cardManager.addCardToUserCollection("Unicorn"));
    }

    @Test
    public void testGetCardType() {
        assertEquals("Creature", cardManager.getCardType("Dragon"));
        assertEquals("Carta no encontrada", cardManager.getCardType("Unicorn"));
    }

    @Test
    public void testShowUserCollection() {
        cardManager.addCardToUserCollection("Dragon");
        cardManager.addCardToUserCollection("Dragon");
        cardManager.addCardToUserCollection("Fireball");
        String expected = "Dragon - Creature, Cantidad: 2\nFireball - Spell, Cantidad: 1\n";
        assertEquals(expected, cardManager.showUserCollection());
    }

    @Test
    public void testShowUserCollectionByType() {
        cardManager.addCardToUserCollection("Dragon");
        cardManager.addCardToUserCollection("Dragon");
        cardManager.addCardToUserCollection("Fireball");
        String expected = "Fireball - Spell, Cantidad: 1\nDragon - Creature, Cantidad: 2\n"; // Sorted by the default
                                                                                             // ordering of Strings
        assertEquals(expected, cardManager.showUserCollectionByType());
    }

    @Test
    public void testIsCardInUserCollection() {
        assertFalse(cardManager.isCardInUserCollection("Dragon"));
        cardManager.addCardToUserCollection("Dragon");
        assertTrue(cardManager.isCardInUserCollection("Dragon"));
    }

    @Test
    public void testGetCardCountInUserCollection() {
        assertEquals(0, cardManager.getCardCountInUserCollection("Dragon"));
        cardManager.addCardToUserCollection("Dragon");
        cardManager.addCardToUserCollection("Dragon");
        assertEquals(2, cardManager.getCardCountInUserCollection("Dragon"));
    }
}
