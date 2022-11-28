package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private final static int LOTTO_SIZE = 6;
    LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또 번호를 생성 테스트")
    @Test
    void lottoGeneratorTest() {
        // when
        List<UserLotto> userLottos = lottoGenerator.generatorUserLotto(3);

        // then
        assertThat(userLottos.size()).isEqualTo(3);
    }
}
