package player;

import Card.Card;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import Card.CardGenerator;

@Getter
@Slf4j
public class Player {
    private static final int DEFAULT_HEALTH_VALUE = 30;
    private static final int DEFAULT_MANA_SLOTS = 0;
    private static final int DEFAULT_MANA = 0;
    private static final int MAXIMUM_MANA_SLOTS = 10;
    private static final int DEFAULT_CARD_NUMBER = 20;
    private static final int DEFAULT_NUMBER_OF_CARDS_TO_RAND = 3;
    private static final Random rand = new Random();
    public static final int CHANCE_TO_ATTACK = 4;

    private final String name;

    private int cardsNumber;
    private int health;
    private int manaSlots;
    private int mana;

    private List<Card> cardList;
    private Hand hand;
    private boolean active = false;

    public Player(String name) {
        this.name = name;
        setDefaultData();
        cardList = CardGenerator.generate();
        hand = new Hand();
        HandFillService.fillHandWithData(DEFAULT_NUMBER_OF_CARDS_TO_RAND, hand, cardList);
        logPlayerState();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Player: ");
        stringBuilder.append(getName());
        stringBuilder.append(" has ");
        stringBuilder.append(getHealth());
        stringBuilder.append(" health and ");
        stringBuilder.append(getMana());
        stringBuilder.append(" mana ");
        stringBuilder.append(" with ");
        stringBuilder.append(getManaSlots());
        stringBuilder.append(getHand().getHandCardList());
        stringBuilder.append(getCardList());
        return stringBuilder.toString();
    }

    private void setDefaultData() {
        health = DEFAULT_HEALTH_VALUE;
        manaSlots = DEFAULT_MANA_SLOTS;
        cardsNumber = DEFAULT_CARD_NUMBER;
        mana = DEFAULT_MANA;
    }

    private void logPlayerState() {
        log.info(toString());
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public void addManaSlot() {
        if(manaSlots < MAXIMUM_MANA_SLOTS) {
            manaSlots++;
        }
    }

    public void refillMana() {
        mana = manaSlots;
    }

    public void drawCardFromDeck() {
        HandFillService.putNewCardToHand(hand, cardList);
    }

    public boolean canPlayCard() {
        if(!hasManaToPlayAnyCard()) {
            log.info("Player has not have enough mana to play any card...");
            return false;
        }
        return true;
    }

    private boolean hasManaToPlayAnyCard() {
        List<Card> affordableToPlayCards = getAffordableToPlayCards();
        return affordableToPlayCards.size() != 0;
    }

    private List<Card> getAffordableToPlayCards() {
        List<Card> handCardList = hand.getHandCardList();
        return handCardList.stream().filter(card -> mana >= card.getCardDamage()).collect(Collectors.toList());
    }

    public Card playCard() {
        if(!playerWantToAttack()) {
            return null;
        }

        List<Card> affordableToPlayCards = getAffordableToPlayCards();
        Card randomCard = getRandomCard(affordableToPlayCards);
        cardList.remove(randomCard);
        return randomCard;
    }

    private boolean playerWantToAttack() {
        final int chosenNumber = rand.nextInt(10);
        return chosenNumber > CHANCE_TO_ATTACK;
    }

    private static Card getRandomCard(List<Card> availableCardList) {
        final int randomIndex = rand.nextInt(availableCardList.size());
        return availableCardList.get(randomIndex);
    }

    public void consumeMana(int cardDamage) {
        mana -= cardDamage;
        log.info(name + ": consumed mana: " + cardDamage + " rest: " + mana);
    }

    public void consumeHealth(int cardDamage) {
        health -= cardDamage;
        log.info(name + ": consumed health: " + cardDamage + " rest: " + health);
    }
}
