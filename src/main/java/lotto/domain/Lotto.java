package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
