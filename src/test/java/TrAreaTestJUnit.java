import org.example.TrArea;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrAreaTestJUnit {

    @Test
    @DisplayName("Валидные значения")
    void testValid() {
        assertEquals(24, TrArea.getArea(8,6));
    }

    @Test
    @DisplayName("Невалидные значения")
    void testInvalid() {
        assertThrows(IllegalArgumentException.class, () -> TrArea.getArea(-8,0));
    }
}