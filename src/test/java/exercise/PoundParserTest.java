package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PoundParserTest {
    private final PoundParser parser= new PoundParser();

    @Test
    void when_parsing_pennies_value_then_return_correct_value() {
        Long asPennies = parser.getAsPennies("1p 1s 1d");
        assertThat(asPennies).isEqualTo(253L);
    }

    @Test
    void when_parsing_pennies_to_string_then_return_correct_value() {
        String penniesAsString = parser.getPenniesAsString(253L);
        assertThat(penniesAsString).isEqualTo("1p 1s 1d");
    }
}