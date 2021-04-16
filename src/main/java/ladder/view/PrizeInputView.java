package ladder.view;

import java.util.Scanner;

public class PrizeInputView {
    private static final String ALL = "ALL";

    private final Scanner scanner;
    private String playerName;
    private boolean isAll = false;

    public PrizeInputView() {
        scanner = new Scanner(System.in);
    }

    public void inputPlayerNameForPrize() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        playerName = scanner.nextLine();
        changeIsAll();
    }

    public boolean isAll() {
        return isAll;
    }

    private void changeIsAll() {
        isAll = ALL.equalsIgnoreCase(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }
}
