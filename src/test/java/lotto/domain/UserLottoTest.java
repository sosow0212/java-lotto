package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoTest {
    @DisplayName("UserLotto 생성자 및 Getter 테스트")
    @Test
    void userLottoConstructorTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        UserLotto userLotto = new UserLotto(numbers);

        // when
        List<Integer> result = userLotto.getLotto();

        // then
        assertThat(result).isEqualTo(numbers);
    }
}
