package Card;

import org.junit.jupiter.api.Test;
import player.Player;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CardGeneratorTest {
    @Test
    public void shouldGenerate20CardsByDefault() {
        final List<Card> generatedCards = CardGenerator.generate();
        assertThat("Should generatedCards 20 cards by default", generatedCards.size(), is(equalTo(20)));
    }

    @Test
    public void playerShouldHaveCardsWithSpecifiedValuesByDefault() {
        final List<Card> cards = CardGenerator.generate();
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
