package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.domain.Winning;
import lotto.view.OutputView;

public class LottoCalculateService {
    private static final int THREE_NUMBER_MATCHES = 3;
    private static final int FOUR_NUMBER_MATCHES = 4;
    private static final int FIVE_NUMBER_MATCHES = 5;
    private static final int SIX_NUMBER_MATCHES = 6;
    private static final int BONUS_ENUM_LABEL = 7;
    private final OutputView outputView = new OutputView();
    private Map<Winning, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {
        countLottoWinningCount(user, lotto);
        outputView.responseWinningHistory(countOfWinning);
        outputView.responseYieldOfLotto(getYieldOfLotto(user, user.getWinningPrice()));
    }

    public void countLottoWinningCount(User user, Lotto lotto) {
        List<UserLotto> userLottos = user.getLottos();
        userLottos
                .stream()
                .forEach(userLotto -> countLottoWinning(user, userLotto.getNumbers(), lotto));
    }

    public double getYieldOfLotto(User user, int totalPrice) {
        double yield = ((double) totalPrice / user.getBuyingPrice() * 100.0);
        return yield;
    }

    public void countLottoWinning(User user, List<Integer> numbers, Lotto lotto) {
        int countContainsOfLotto = countUserNumbersContainLotto(numbers, lotto.getNumbers());
        if (isNumberMatchedNormal(countContainsOfLotto)) {
            inputCountOfWinning(Winning.FIND.valueOf(countContainsOfLotto));
            user.addWinningPrice(Winning.FIND.valueOf(countContainsOfLotto).getPrice());
            return;
        }
        if (isNumberMatchedFiveWithBonus(countContainsOfLotto, numbers, lotto)) {
            inputCountOfWinning(Winning.FIND.valueOf(BONUS_ENUM_LABEL));
            user.addWinningPrice(Winning.FIND.valueOf(BONUS_ENUM_LABEL).getPrice());
            return;
        }
        if (isNumberMatchedFive(countContainsOfLotto, numbers, lotto)) {
            inputCountOfWinning(Winning.FIND.valueOf(countContainsOfLotto));
            user.addWinningPrice(Winning.FIND.valueOf(countContainsOfLotto).getPrice());
            return;
        }
    }

    public int countUserNumbersContainLotto(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void inputCountOfWinning(Winning winning) {
        countOfWinning.put(winning, countOfWinning.getOrDefault(winning, 0) + 1);
    }

    public boolean isNumberMatchedNormal(int countContainsOfLotto) {
        if (countContainsOfLotto == THREE_NUMBER_MATCHES || countContainsOfLotto == FOUR_NUMBER_MATCHES || countContainsOfLotto == SIX_NUMBER_MATCHES) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFiveWithBonus(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == FIVE_NUMBER_MATCHES && numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFive(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == FIVE_NUMBER_MATCHES && !numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

}
