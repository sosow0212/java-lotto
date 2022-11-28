package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();

    public int askBuyingPrice() {
        try {
            String input = Console.readLine();
            // 예외처리
            return inputParser.numberParser(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askBuyingPrice();
        }
    }

    public List<Integer> askCorrectNumbers() {
        try {
            String input = Console.readLine();
            // 예외처리
            return inputParser.correctNumbersParser(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askCorrectNumbers();
        }
    }

    public int askBonusNumber() {
        try {
            String input = Console.readLine();
            // 예외처리
            return inputParser.numberParser(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askBonusNumber();
        }
    }
}
