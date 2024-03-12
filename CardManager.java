package com.uvg.algoritmos;

import java.util.Map;

public class CardManager {
    private Map<String, String> cardMap;

    public CardManager(Map<String, String> cardMap) {
        this.cardMap = cardMap;
    }

    public void addCard(String cardName, String cardType) {
        cardMap.put(cardName, cardType);
    }

    public String getCardType(String cardName) {
        return cardMap.getOrDefault(cardName, "Card not found");
    }

    public boolean addCardToUserCollection(String cardName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCardToUserCollection'");
    }

    public char[] showUserCollection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showUserCollection'");
    }

    public char[] showUserCollectionByType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showUserCollectionByType'");
    }

}
