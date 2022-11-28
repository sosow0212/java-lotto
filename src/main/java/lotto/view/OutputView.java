package lotto.view;

import java.util.List;
import lotto.domain.UserLotto;

public class OutputView {
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

    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        // 추후에 추가
    }
}
