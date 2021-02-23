package test;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OldFashionPoundTest {
    public static final String PRICE = "PRICE";
    public static final String ANOTHER_PRICE = "ANOTHER_PRICE";

    private final Parser parser = mock(Parser.class);

    private final OldFashionPound oldFashionPound= new OldFashionPound(parser);

    @Test
    void when_adding_two_prices_then_return_sum() {
        when(parser.getAsPennies(PRICE)).thenReturn(1L);
        when(parser.getAsPennies(ANOTHER_PRICE)).thenReturn(2L);
        when(parser.getPenniesAsString(3L)).thenReturn("sum");

        String result = oldFashionPound.sum(PRICE, ANOTHER_PRICE);

        assertThat(result).isEqualTo("sum");
    }

}