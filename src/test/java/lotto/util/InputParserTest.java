package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    InputParser inputParser = new InputParser();

    @DisplayName("String -> int 파싱 테스트")
    @Test
    void buyingPriceParserTest() {
        // given
        String input = "1000";

        // when
        int result = inputParser.numberParser(input);

        // then
        assertThat(result).isEqualTo(1000);
    }

    @DisplayName("로또 당첨 번호 파싱 테스트")
    @Test
    void correctNumbersParserTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> result = inputParser.correctNumbersParser(input);

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
