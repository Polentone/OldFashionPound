package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OldFashionPoundIT {
    private final Pound pound = new OldFashionPound(new PoundParser());
    @Test
    void when_requesting_sum_then_the_correct_sum_is_returned() {
        String result = pound.sum("5p 17s 8d", "3p 4s 10d");
        assertThat(result).isEqualTo("9p 2s 6d");
    }

    @Test
    void when_requesting_subraction_then_the_correct_value_is_returned() {
        String result = pound.subtract("5p 17s 8d", "3p 4s 10d");
        assertThat(result).isEqualTo("2p 12s 10d");
    }

    @Test
    void when_requesting_moltiplication_then_the_correct_value_is_returned() {
        String result = pound.multiply("5p 17s 8d", 2);
        assertThat(result).isEqualTo("11p 15s 4d");
    }

    @Test
    void when_requesting_division_then_the_correct_value_is_returned() {
        String result = pound.divide("5p 17s 8d", 3);
        assertThat(result).isEqualTo("1p 19s 2d (2d)");
    }

    @Test
    void when_result_subtraction_return_negative_number_then_is_correct() {
        String result = pound.subtract("3p 4s 10d", "5p 17s 8d");
        assertThat(result).isEqualTo("- 2p 12s 10d");
    }
}
