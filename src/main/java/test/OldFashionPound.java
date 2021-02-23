package test;

public class OldFashionPound implements Pound {

    private final Parser parser;

    public OldFashionPound(Parser parser) {
        this.parser = parser;
    }

    @Override
    public String sum(String firstPrice, String secondPrice) {
        Long sum = parser.getAsPennies(firstPrice) + parser.getAsPennies(secondPrice);
        return parser.getPenniesAsString(sum);
    }
}
