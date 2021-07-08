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
    public void playerShouldHave20Cards() {
        player = new Player(TEST_PLAYER_NAME);
        assertThat("Player should have 20 Damage cards by default", player.getCards().size(), is(equalTo(20)));
    }

    @Test
    public void playerShouldHaveCardsWithSpecifiedValuesByDefault() {
        player = new Player(TEST_PLAYER_NAME);
        final List<Card> cards = player.getCards();
        assertThat(getCardsAmountWithValue(cards, 0), is(2L));
        assertThat(getCardsAmountWithValue(cards, 1), is(2L));
        assertThat(getCardsAmountWithValue(cards, 2), is(3L));
        assertThat(getCardsAmountWithValue(cards, 3), is(4L));
        assertThat(getCardsAmountWithValue(cards, 4), is(3L));
        assertThat(getCardsAmountWithValue(cards, 5), is(2L));
        assertThat(getCardsAmountWithValue(cards, 6), is(2L));
        assertThat(getCardsAmountWithValue(cards, 7), is(1L));
        assertThat(getCardsAmountWithValue(cards, 8), is(1L));
    }

    private long getCardsAmountWithValue(List<Card> cards, int damage) {
        return cards.stream().map(card -> card.getCardDamage()).filter(integer -> integer.equals(damage)).count();
    }
}
