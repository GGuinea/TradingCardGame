import Card.Card;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import player.HandFillService;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Game {
    private Player activePlayer;
    private Player opponent;
    private final int NUMBER_OF_PLAYERS = 2;

    @Getter
    private final List<Player> playersList = new ArrayList<>();

    public Game() {
        activePlayer = new Player("PlayerOne");
        opponent = new Player("PlayerTwo");
        playersList.add(activePlayer);
        playersList.add(opponent);

        setActivePlayer();
        giveAdditionalCardForNotStartingPlayer();
        play();
    }

    private void play() {
        boolean isGameRunning = true;
        boolean switchPlayerFlag = false;
        while(isGameRunning) {
            activePlayer.addManaSlot();
            activePlayer.refillMana();
            activePlayer.drawCardFromDeck();

            if(activePlayer.canPlayCard()) {
                Card cardToAttack = activePlayer.playCard();
                if(cardToAttack != null) {
                    attack(cardToAttack);
                } else {
                    switchPlayerFlag = true;
                }
            } else {
                switchPlayerFlag = true;
            }

            if(isOpponentDead()) {
                isGameRunning = false;
            }

            switchPlayers(switchPlayerFlag);
        }
    }

    private boolean isOpponentDead() {
        final boolean isOpponentHealthBelowOrZero = opponent.getHealth() <= 0;
        if(isOpponentHealthBelowOrZero) {
            log.info(opponent.getName() + "DEAD!");
            log.info(activePlayer.getName() + "WIN!");
        }
        return isOpponentHealthBelowOrZero;
    }

    private void attack(Card cardToAttack) {
        final int cardDamage = cardToAttack.getCardDamage();
        activePlayer.consumeMana(cardDamage);
        opponent.consumeHealth(cardDamage);
    }

    private void switchPlayers(boolean isSwitch) {
        if(!isSwitch) {
            return;
        }

        Player previousActivePlayer = activePlayer;
        activePlayer = opponent;
        opponent = previousActivePlayer;
    }

    private void giveAdditionalCardForNotStartingPlayer() {
        HandFillService.fillHandWithData(1, opponent.getHand(), opponent.getCardList());
    }

    private void setActivePlayer() {
        final int chosenPlayerNo = chooseStartingPlayer();
        if(chosenPlayerNo == 1) {
            activePlayer.setActive(true);
        } else {
            opponent.setActive(true);
        }
    }

    private int chooseStartingPlayer() {
        Random rand = new Random();
        return rand.ints(1, NUMBER_OF_PLAYERS + 1).findFirst().getAsInt();
    }
}
