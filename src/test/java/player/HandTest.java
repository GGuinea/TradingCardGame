package player;

import Card.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

class HandTest {
    Hand hand = new Hand();
    Card card = new Card(0);

    @Test
    public void shouldHandBeEmptyAfterInitialization() {
        List<Card> handCardList = hand.getHandCardList();
        assertThat("Hand should be empty after initialization", handCardList.size(), equalTo(0));
    }

    @Test
    public void shouldBeSizeOneAfterOneCardAdded() {
        hand.addCardToHand(card);
        List<Card> handCardList = hand.getHandCardList();
        assertThat("Should have only one card in container", handCardList.size(), equalTo(1));
    }

    @Test
    public void shouldBeSizeOneAfterAddingTwoAndRemovingOneCard() {
        Card cardTwo = new Card(1);
        hand.addCardToHand(card);
        hand.addCardToHand(cardTwo);
        List<Card> handCardList = hand.getHandCardList();
        assertThat("Should have two card in container", handCardList.size(), equalTo(2));
        hand.removeCardFromHand(card);
        handCardList = hand.getHandCardList();
        assertThat("Should have only one card in container", handCardList.size(), equalTo(1));
    }
}