package lotto.domain;

import java.util.List;
import lotto.util.LottoGenerator;

public class User {
    private final int buyingPrice;
    private final List<UserLotto> lottos;

    public User(int buyingPrice) {
        // 예외 처리 진행하기
        this.buyingPrice = buyingPrice;
        this.lottos = LottoGenerator.generatorUserLotto(getLottoQuantity());
    }

    private int getLottoQuantity() {
        return this.buyingPrice / 1000;
    }
}
