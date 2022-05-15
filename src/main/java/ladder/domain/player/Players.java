package ladder.domain.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    private void validate(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("players는 빈 값일 수 없습니다.");
        }

        if (players.size() < MIN_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(String.format("players(%s명)는 %s명 보다 적을 수  없습니다.", players.size(), MIN_NUMBER_OF_PLAYERS));
        }
    }

    public static Players from(List<String> playerNames) {
        return new Players(
                playerNames.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
    }

    public int numbers() {
        return players.size();
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining());
    }
}
