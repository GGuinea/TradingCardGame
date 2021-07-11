import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private final int NUMBER_OF_PLAYERS = 2;

    @Getter
    private final List<Player> playersList = new ArrayList<>();

    public Game() {
        playerOne = new Player("PlayerOne");
        playerTwo = new Player("PlayerTwo");
        playersList.add(playerOne);
        playersList.add(playerTwo);

        setActivePlayer();
    }

    private void setActivePlayer() {
        final int chosenPlayerNo = chooseStartingPlayer();
        if(chosenPlayerNo == 1) {
            playerOne.setActive(true);
        } else {
            playerTwo.setActive(true);
        }
    }

    private int chooseStartingPlayer() {
        Random rand = new Random();
        return rand.nextInt(NUMBER_OF_PLAYERS+1);
    }
}
