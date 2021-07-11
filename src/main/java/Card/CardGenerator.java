package Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CardGenerator {
    public static List<Card> generate() {
        List<Card> cardList = new ArrayList<>();
        addCardsWithDamageValue(2, 0, cardList);
        addCardsWithDamageValue(2, 1, cardList);
        addCardsWithDamageValue(3, 2, cardList);
        addCardsWithDamageValue(4, 3, cardList);
        addCardsWithDamageValue(3, 4, cardList);
        addCardsWithDamageValue(2, 5, cardList);
        addCardsWithDamageValue(2, 6, cardList);
        addCardsWithDamageValue(1, 7, cardList);
        addCardsWithDamageValue(1, 8, cardList);
        return cardList;
    }

    private static void addCardsWithDamageValue(int amountOfCards, int damageValue, List<Card> cardList) {
        IntStream.range(0, amountOfCards).forEach(index -> cardList.add(new Card(damageValue)));
    }
}
