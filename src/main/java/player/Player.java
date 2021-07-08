package player;

import Card.Card;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import Card.CardGenerator;

@Getter
@Slf4j
public class Player {
    private static final int DEFAULT_HEALTH_VALUE = 30;
    private static final int DEFAULT_MANA_VALUE = 0;
    private static final int DEFAULT_CARD_NUMBER = 20;

    private final String name;
    private int cardsNumber;
    private int health;
    private int manaSlots;
    private List<Card> cardList;

    public Player(String name) {
        this.name = name;
        health = DEFAULT_HEALTH_VALUE;
        manaSlots = DEFAULT_MANA_VALUE;
        cardsNumber = DEFAULT_CARD_NUMBER;
        cardList = CardGenerator.generate();
        log.info(this.toString());
    }

    public List<Card> getCards() {
        return cardList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Player: ");
        stringBuilder.append(getName());
        stringBuilder.append(" has ");
        stringBuilder.append(getHealth());
        stringBuilder.append(" health and ");
        stringBuilder.append(getManaSlots());
        stringBuilder.append(" mana ");
        return stringBuilder.toString();
    }
}
