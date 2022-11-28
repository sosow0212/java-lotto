package lotto.domain;

import java.util.List;
import lotto.util.LottoGenerator;

public class User {
    private final int buyingPrice;
    private final List<UserLotto> lottos;

    public User(int buyingPrice) {
        // 예외 처리 진행하기
        this.buyingPrice = buyingPrice;
        this.lottos = createLottos();
    }

    private List<UserLotto> createLottos() {
        return LottoGenerator.createLotto(getLottoQuantity());
    }

    private int getLottoQuantity() {
        return this.buyingPrice / 1000;
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    public double getYieldOfLotto(double totalPrice) {
        return (totalPrice / buyingPrice * 100);
    }
}
