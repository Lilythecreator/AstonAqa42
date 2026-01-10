import org.example.TrArea;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TrAreaTestNG {

    @Test(testName = "Валидные значения")
    void testValid() {
        Assert.assertEquals(24, TrArea.getArea(8,6));
    }

    @Test(testName = "Невалидные значения")
    void testInvalid() {
        Assert.assertThrows(IllegalArgumentException.class, () -> TrArea.getArea(-8,0));
    }
}