import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import player.Player;

@Slf4j
@RequiredArgsConstructor
public class Game {
    private final Player playerOne;
    private final Player playerTwo;
}
