package player;

import Card.Card;

import java.util.List;
import java.util.Random;

public class HandFillService {
    static final Random rand = new Random();

    public static void fillHandWithData(int numberOfCardsToRand, Hand hand, List<Card> availableCardList) {
        for(int i = 0; i < numberOfCardsToRand; i++) {
            fillHand(hand, availableCardList);
        }
    }

    public static void putNewCardToHand(Hand hand, List<Card> availableCardList) {
        fillHand(hand, availableCardList);
    }

    private static void fillHand(Hand hand, List<Card> availableCardList) {
        final Card chosenCard = getRandomCard(availableCardList);
        if(chosenCard == null) {
            return;
        }

        hand.addCardToHand(chosenCard);
        availableCardList.remove(chosenCard);
    }

    private static Card getRandomCard(List<Card> availableCardList) {
        if(availableCardList.size() == 0) {
            return null;
        }

        final int randomIndex = rand.nextInt(availableCardList.size());
        return availableCardList.get(randomIndex);
    }
}
