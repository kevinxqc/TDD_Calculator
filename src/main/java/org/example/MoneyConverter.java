package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConverter {

    private static final BigDecimal USD_TO_EUR_RATE = new BigDecimal("0.92");
    private static final BigDecimal EUR_TO_USD_RATE = BigDecimal.ONE.divide(USD_TO_EUR_RATE, 6, RoundingMode.HALF_UP);

    public BigDecimal usdToEur(BigDecimal usd) {
        if (usd == null) throw new IllegalArgumentException("Amount cannot be null");
        return usd.multiply(USD_TO_EUR_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal eurToUsd(BigDecimal eur) {
        if (eur == null) throw new IllegalArgumentException("Amount cannot be null");
        return eur.multiply(EUR_TO_USD_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
