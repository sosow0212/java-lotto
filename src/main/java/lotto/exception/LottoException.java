package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoException {
    private final static int PERMITTED_LOTTO_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateOverlapNumbers(numbers);
        validateNumbersPermittedRange(numbers);
    }

    public void validateBonusNumbers(List<Integer> inputNumbers, int inputBonusNumber) {
        validateBonusNumberPermittedRange(inputBonusNumber);
        validateBonusNumberOverlapNumbers(inputNumbers, inputBonusNumber);
    }

    public void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입력해주세요.");
        }
    }

    public void validateOverlapNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        inputNumbers.stream().map(number -> numbers.add(number)).collect(Collectors.toList());
        if (numbers.size() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 번호 중에 중복 번호가 있습니다.");
        }
    }

    public void validateNumbersPermittedRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또의 범위는 1~45입니다.");
            }
        }
    }

    public void validateBonusNumberPermittedRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또의 범위는 1~45입니다.");
        }
    }

    public void validateBonusNumberOverlapNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복됩니다.");
        }
    }
}
