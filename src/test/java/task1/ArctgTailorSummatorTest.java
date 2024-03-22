package task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class ArctgTailorSummatorTest {
    double eps = 0.1;

    @ParameterizedTest
    @ValueSource(doubles = {-0.5, -0.75, -1.0 })
    public void testNegativeValues(double x) {
        assertEquals(Math.atan(x), ArctgTailorSummator.getSum(x), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 0.75, 1.0})
    public void testPositiveValues(double x) {
        assertEquals(Math.atan(x), ArctgTailorSummator.getSum(x), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.001, -0.01})
    public void testCloseToZero(double x) {
        assertEquals(Math.atan(x), ArctgTailorSummator.getSum(x), eps);
    }
}