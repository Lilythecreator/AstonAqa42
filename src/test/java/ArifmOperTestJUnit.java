import org.example.ArifmOper;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArifmOperTestJUnit {

    @Test
    @DisplayName("Проверка суммы")
    void checkSum() {
        assertEquals(19, ArifmOper.sum(14,5));
    }

    @Test
    @DisplayName("Проверка разности")
    void checkSub() {
        assertEquals(9, ArifmOper.sub(14,5));
    }

    @Test
    @DisplayName("Проверка умножения")
    void checkMul() {
        assertEquals(70, ArifmOper.mul(14,5));
    }

    @Test
    @DisplayName("Проверка деления")
    void checkDiv() {
        assertEquals(2.8, ArifmOper.div(14,5));
        assertThrows(ArithmeticException.class, () -> ArifmOper.div(14,0));
    }
}
