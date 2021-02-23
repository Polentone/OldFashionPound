package exercise;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import static java.lang.Long.parseLong;

public class PoundParser implements Parser {
    @Override
    public String getPenniesAsString(Long total) {
        Long pound = Math.abs(total / (20 * 12));
        Long scellins = Math.abs((total % (20 * 12)) /12);
        Long pennies = Math.abs(((total % (20 * 12)) % 12));
        return formatAsString(total, pound, scellins, pennies);
    }

    private String formatAsString(Long total, Long pound, Long scellins, Long pennies) {
        return (total < 0 ? "- " : "") +
                format(pound, "p ") +
                format(scellins, "s ") +
                format(pennies, "d");
    }

    private String format(Long pound, String symbol) {
        return pound != 0 ? pound + symbol : "";
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
