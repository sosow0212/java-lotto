package lotto.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String DECIMAL_FORMAT = "###,##0.0";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private HashMap<LottoInfo, Integer> userScore = new HashMap<>();
    private HashMap<Integer, LottoInfo> select = new HashMap<>();

    public void run() {
        initSelect();
        User user = setUser();
        Lotto lotto = setLotto();
        getResult(user, lotto);
    }

    public void initSelect() {
        select.put(3, LottoInfo.THIRD);
        select.put(4, LottoInfo.FOURTH);
        select.put(5, LottoInfo.FIFTH);
        select.put(6, LottoInfo.SIX);
    }

    private void getResult(User user, Lotto lotto) {
        for (UserLotto userLotto : user.getLottos()) {
            long correctCount = userLotto.getLotto()
                    .stream()
                    .filter(number -> lotto.isContainsNumber(number))
                    .count();
            inputData(userLotto.getLotto(), lotto, (int) correctCount);
        }
        String yield = getYieldOfLotto(user);
        outputView.printResult(yield, userScore);
    }

    private void inputData(List<Integer> userLotto, Lotto lotto, int correctCount) {
        if (correctCount == 5 && lotto.isContainsBonusNumber(userLotto)) {
            userScore.put(LottoInfo.FIFTH_WITH_BONUS,
                    userScore.getOrDefault(LottoInfo.FIFTH_WITH_BONUS, 0) + 1);
            return;
        }
        if (correctCount >= 3) {
            userScore.put(select.get(correctCount),
                    userScore.getOrDefault(select.get(correctCount), 0) + 1);

        }
    }

    public String getYieldOfLotto(User user) {
        long totalPrice = getTotalPrice();
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format(user.getYieldOfLotto(totalPrice));
    }

    private long getTotalPrice() {
        long totalPrice = 0;
        for (LottoInfo info : userScore.keySet()) {
            totalPrice += (userScore.get(info) * info.getPrice());
        }
        return totalPrice;
    }

    public User setUser() {
        int buyingPrice = getBuyingPrice();
        User user = new User(buyingPrice);
        outputView.printBuyingQuantityOfLotto(buyingPrice);
        outputView.printUserLottos(user.getLottos());
        return user;
    }

    private int getBuyingPrice() {
        outputView.printAskBuyingPrice();
        int buyingPrice = inputView.askBuyingPrice();
        return buyingPrice;
    }

    public Lotto setLotto() {
        List<Integer> correctNumbers = getCorrectNumbers();
        int bonusNumbers = getBonusNumber(correctNumbers);
        Lotto lotto = new Lotto(correctNumbers, bonusNumbers);
        return lotto;
    }

    private List<Integer> getCorrectNumbers() {
        outputView.printAskCorrectNumbers();
        List<Integer> correctNumbers = inputView.askCorrectNumbers();
        return correctNumbers;
    }

    private int getBonusNumber(List<Integer> correctNumbers) {
        outputView.printAskBonusNumber();
        int bonusNumbers = inputView.askBonusNumber(correctNumbers);
        return bonusNumbers;
    }
}
