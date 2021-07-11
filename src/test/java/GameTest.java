import org.apache.commons.lang3.BooleanUtils;
import org.junit.jupiter.api.Test;
import player.Player;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class GameTest {
    @Test
    public void shouldCreateTwoPlayers() {
        Game game = new Game();
        List<Player> playersList = game.getPlayersList();
        assertThat("Should be only two players", playersList.size(), equalTo(2));
    }

    @Test
    public void shouldOnePlayerBeActive() {
        Game game = new Game();
        List<Player> playersList = game.getPlayersList();
        final long numberOfActivePlayers = playersList.stream().map(Player::isActive).filter(BooleanUtils::isTrue).count();
        assertThat("Should be only one player active", numberOfActivePlayers, equalTo(1L));
    }

}