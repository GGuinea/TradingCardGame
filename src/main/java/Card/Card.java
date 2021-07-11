package Card;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Card {
    final private int cardDamage;

    @Override
    public String toString() {
        return "Card with damage: " + cardDamage;
    }
}
