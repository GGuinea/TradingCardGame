package player;

import Card.Card;

import java.util.List;
import java.util.Random;

public class HandFillService {
    static final Random rand = new Random();

    public static void fillHandWithData (int numberOfCardsToRand, Hand hand, List<Card> availableCardList) {
        for(int i = 0; i < numberOfCardsToRand; i++) {
            fillHand(hand, availableCardList);
        }
    }

    private static void fillHand(Hand hand, List<Card> avilableCardList) {
        final Card chosenCard = getRandomCard(avilableCardList);
        hand.addCardToHand(chosenCard);
        avilableCardList.remove(chosenCard);
    }

    private static Card getRandomCard(List<Card> availableCardList) {
        final int randomIndex = rand.nextInt(availableCardList.size());
        return availableCardList.get(randomIndex);
    }
}
