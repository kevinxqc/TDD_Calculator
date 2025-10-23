
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Money Converter Tests (BigDecimal version)")
class MoneyConverterTest {

    private MoneyConverter converter;

    @BeforeEach
    void setUp() {
        converter = new MoneyConverter();
    }

    @Test
    @DisplayName("should correctly convert USD to EUR")
    void testUsdToEur() {
        BigDecimal result = converter.usdToEur(new BigDecimal("10"));
        assertThat(result).isEqualByComparingTo(new BigDecimal("9.20"));
    }

    @Test
    @DisplayName("should correctly convert EUR to USD")
    void testEurToUsd() {
        BigDecimal result = converter.eurToUsd(new BigDecimal("10"));
        assertThat(result).isEqualByComparingTo(new BigDecimal("10.87"));
    }

    @Test
    @DisplayName("should handle zero correctly")
    void testZeroConversion() {
        assertThat(converter.usdToEur(BigDecimal.ZERO))
                .isEqualByComparingTo(BigDecimal.ZERO);
        assertThat(converter.eurToUsd(BigDecimal.ZERO))
                .isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("should handle negative values correctly")
    void testNegativeConversion() {
        assertThat(converter.usdToEur(new BigDecimal("-5")))
                .isEqualByComparingTo(new BigDecimal("-4.60"));
        assertThat(converter.eurToUsd(new BigDecimal("-5")))
                .isEqualByComparingTo(new BigDecimal("-5.43"));
    }

    @Test
    @DisplayName("should throw IllegalArgumentException for null input")
    void testNullInput() {
        assertThatThrownBy(() -> converter.usdToEur(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }
}
