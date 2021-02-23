package exercise;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OldFashionPoundTest {
    public static final String PRICE = "PRICE";
    public static final String ANOTHER_PRICE = "ANOTHER_PRICE";
    public static final String RESULT = "result";

    private final Parser parser = mock(Parser.class);

    private final OldFashionPound oldFashionPound = new OldFashionPound(parser);

    @Test
    void when_adding_two_prices_then_return_sum() {
        when(parser.getAsPennies(PRICE)).thenReturn(1L);
        when(parser.getAsPennies(ANOTHER_PRICE)).thenReturn(2L);
        when(parser.getPenniesAsString(3L)).thenReturn(RESULT);

        String result = oldFashionPound.sum(PRICE, ANOTHER_PRICE);

        assertThat(result).isEqualTo(RESULT);
    }

    @Test
    void when_subtracting_two_prices_then_return_result() {
        when(parser.getAsPennies(PRICE)).thenReturn(2L);
        when(parser.getAsPennies(ANOTHER_PRICE)).thenReturn(1L);
        when(parser.getPenniesAsString(1L)).thenReturn(RESULT);

        String result = oldFashionPound.subtract(PRICE, ANOTHER_PRICE);

        assertThat(result).isEqualTo(RESULT);
    }

    @Test
    void when_multiplicating_a_price_then_return_correct_price() {
        when(parser.getAsPennies(PRICE)).thenReturn(5L);
        when(parser.getPenniesAsString(15L)).thenReturn(RESULT);

        String result = oldFashionPound.multiply(PRICE, 3);

        assertThat(result).isEqualTo(RESULT);
    }

    @Test
    void when_dividing_a_price_then_return_correct_price_and_correct_remainder() {
        when(parser.getAsPennies(PRICE)).thenReturn(5L);
        when(parser.getPenniesAsString(1L)).thenReturn(RESULT);
        when(parser.getPenniesAsString(2L)).thenReturn("remainder");

        String result = oldFashionPound.divide(PRICE, 3);

        assertThat(result).isEqualTo(RESULT + " (remainder)");
    }
}