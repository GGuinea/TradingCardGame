package player;

import Card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cardContainer;

    public Hand() {
        this.cardContainer = new ArrayList<>();
    }

    public List<Card> getHandCardList() {
        return cardContainer;
    }

    public void addCardToHand(Card cardToAdd) {
        cardContainer.add(cardToAdd);
    }

    public void removeCardFromHand(Card cardToRemove) {
        cardContainer.remove(cardToRemove);
    }
}
