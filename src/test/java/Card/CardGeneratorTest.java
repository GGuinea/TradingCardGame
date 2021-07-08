package Card;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CardGeneratorTest {
    @Test
    public void shouldGenerate20CardsByDefault() {
        final List<Card> generate = CardGenerator.generate();
        assertThat("Should generate 20 cards by default", generate.size(), is(equalTo(20)));
    }

}