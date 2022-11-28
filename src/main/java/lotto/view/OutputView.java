package lotto.view;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoInfo;
import lotto.domain.UserLotto;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printAskBuyingPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printBuyingQuantityOfLotto(int buyingPrice) {
        System.out.println("\n" + getBuyingQuantity(buyingPrice) + "개를 구매했습니다.");
    }

    private int getBuyingQuantity(int buyingPrice) {
        return buyingPrice / 1000;
    }

    public void printUserLottos(List<UserLotto> userLottos) {
        userLottos.stream().forEach(lotto -> printLotto(lotto.getLotto()));
    }

    public void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printAskCorrectNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printAskBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printResult(String yield, HashMap<LottoInfo, Integer> userScore) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printScore(userScore);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public void printScore(HashMap<LottoInfo, Integer> userScore) {
        for (LottoInfo info : LottoInfo.values()) {
            if (userScore.get(info) == null) {
                userScore.put(info, 0);
            }
            System.out.println(info.getScore() + "개 일치 (" + getLottoPrice(info.getPrice()) + "원) - " + userScore.get(info) + "개");
        }
    }

    public String getLottoPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(price);
    }

    public void printException(String message) {
        System.out.println(ERROR + message);
    }
}
