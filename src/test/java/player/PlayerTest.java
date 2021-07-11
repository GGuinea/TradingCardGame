package player;

import Card.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PlayerTest {
    public static final String TEST_PLAYER_NAME = "TestPlayer";
    private Player player;
    @Test
    public void playerShouldHave30HealthByDefault() {
        player = new Player(TEST_PLAYER_NAME);
        assertThat("Player by default should have 30hp", player.getHealth(), is(equalTo(30)));
    }

    @Test
    public void playerShouldHave0ManaByDefault() {
        player = new Player(TEST_PLAYER_NAME);
        assertThat("Player by default should have 0 mana", player.getManaSlots(), is(equalTo(0)));
    }

    @Test
    public void playerShouldHave3CardsInHandAfterInitialization() {
        player = new Player(TEST_PLAYER_NAME);
        Hand hand = player.getHand();
        List<Card> handCardList = hand.getHandCardList();
        assertThat("Player should have 3 cards in hand after initialization",  handCardList.size(), equalTo(3));
    }

    @Test
    public void playerShouldHave17CardsInDeckAfterInitialization() {
        player = new Player(TEST_PLAYER_NAME);
        List<Card> cardList = player.getCardList();
        assertThat("In deck should be only 17 cards after initialization", cardList.size(), equalTo(17));
    }
}
