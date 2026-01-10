import org.example.NumFactorial;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumFactorialTestJUnit {

    @Test
    @DisplayName("Факториал нуля")
    void factorialZero() {
        assertEquals(1, NumFactorial.factorial(0));
    }

    @Test
    @DisplayName("Факториал единицы")
    void factorialOne() {
        assertEquals(1, NumFactorial.factorial(1));
    }

    @Test
    @DisplayName("Факториал положительного числа")
    void factorialPositiveNum() {
        assertEquals(24, NumFactorial.factorial(4));
        assertEquals(40320, NumFactorial.factorial(8));
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    void factorialNegativeNum() {
        assertThrows(IllegalArgumentException.class, () -> NumFactorial.factorial(-5));
    }
}