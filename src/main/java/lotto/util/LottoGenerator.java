package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.UserLotto;

public class LottoGenerator {
    public static List<UserLotto> generatorUserLotto(int quantity) {
        List<UserLotto> userLottos = new ArrayList<>();
        for(int i=0; i<quantity; i++) {
            userLottos.add(new UserLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return userLottos;
    }
}
