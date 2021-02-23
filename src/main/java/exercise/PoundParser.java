package exercise;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static java.lang.Long.parseLong;

public class PoundParser implements Parser {
    @Override
    public String getPenniesAsString(Long total) {
        Long pound = total / (20 * 12);
        Long scellins = (total % (20 * 12)) /12;
        Long pennies = ((total % (20 * 12)) % 20) / 12;
        return String.format("%sp %ss %sd",pound, scellins, pennies);
    }

    @Override
    public Long getAsPennies(String price) {
        return Arrays.stream(price.split(" ")).map(this::parse).mapToLong(Long::longValue).sum();
    }

    private Long parse(String decimal) {
        if (decimal.contains("d")) {
            return parseLong(removeLastCharacter(decimal));
        }

        if (decimal.contains("s")) {
            return parseLong(removeLastCharacter(decimal)) * 12;
        }

        if (decimal.contains("p")) {
            return parseLong(removeLastCharacter(decimal)) * 12 * 20;
        }
        return 0L;
    }

    private String removeLastCharacter(String value) {
        return StringUtils.chop(value);
    }
}
