package test;

public interface Pound {
    String sum(String price, String anotherPrice);

    String subtract(String price, String anotherPrice);

    String multiply(String price, Integer operator);

    String divide(String price, Integer operator);
}
