package task1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArctgTailorSummator {
    public static double getSum(double x) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal X = BigDecimal.valueOf(x);
        int n = 30;

        for (int i = 0; i < n; i++) {
            BigDecimal numerator = BigDecimal.valueOf(Math.pow(-1, i)).multiply(X.pow(2 * i + 1));
            BigDecimal denominator = BigDecimal.valueOf(2L * i + 1);
            sum = sum.add(numerator.divide(denominator, 20, RoundingMode.HALF_UP));
        }
        return sum.doubleValue();
    }
}