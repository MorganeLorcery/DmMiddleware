package service;

import java.math.BigInteger;

public class Bill {
    String movieName;
    BigInteger outrageousPrice;

    public Bill(String movieName, BigInteger outrageousPrice) {
        this.movieName = movieName;
        this.outrageousPrice = outrageousPrice;
    }

    @Override
    public String toString() {
        return String.valueOf(outrageousPrice);
    }
}
