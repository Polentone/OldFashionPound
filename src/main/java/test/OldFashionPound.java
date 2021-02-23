package test;

public class OldFashionPound implements Pound {

    private final Parser parser;

    public OldFashionPound(Parser parser) {
        this.parser = parser;
    }

    @Override
    public String sum(String price, String anotherPrice) {
        Long sum = parser.getAsPennies(price) + parser.getAsPennies(anotherPrice);
        return parser.getPenniesAsString(sum);
    }

    @Override
    public String subtract(String price, String anotherPrice) {
        Long result = parser.getAsPennies(price) - parser.getAsPennies(anotherPrice);
        return parser.getPenniesAsString(result);
    }

    @Override
    public String multiply(String price, Integer operator) {
        Long result = parser.getAsPennies(price) * operator;
        return parser.getPenniesAsString(result);
    }

    @Override
    public String divide(String price, Integer operator) {
        Long priceAsPennies = parser.getAsPennies(price);
        Long result = priceAsPennies / operator;
        Long remainder = priceAsPennies % operator;
        return parser.getPenniesAsString(result) + "("+ parser.getPenniesAsString(remainder) + ")";
    }
}
