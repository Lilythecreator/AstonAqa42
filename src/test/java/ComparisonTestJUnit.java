import org.example.Comparison;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComparisonTestJUnit {

    @Test
    @DisplayName("Большее число")
    void isGreater() {
        assertEquals("Число 45 больше числа 6", Comparison.compare(45, 6));
    }

    @Test
    @DisplayName("Меньшее число")
    void isLess() {
        assertEquals("Число 6 меньше числа 45", Comparison.compare(6, 45));
    }

    @Test
    @DisplayName("Равные числа")
    void areEqual() {
        assertEquals("Числа равны", Comparison.compare(26, 26));
    }
}