package lotto.domain;

import java.util.List;

public class User {
    private int buyingPrice;
    private List<UserLotto> lottos;

    public User(int buyingPrice) {
        // exception 여기서 진행해보기
        this.buyingPrice = buyingPrice;
        // 추후에 여기서 List<UserLotto> 도 채워야함
    }
}
