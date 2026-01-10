import org.example.Comparison;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ComparisonTestNG {

    @Test(testName = "Большее число")
    void isGreater() {
        Assert.assertEquals("Число 45 больше числа 6", Comparison.compare(45, 6));
    }

    @Test(testName = "Меньшее число")
    void isLess() {
        Assert.assertEquals("Число 6 меньше числа 45", Comparison.compare(6, 45));
    }

    @Test(testName = "Равные числа")
    void areEqual() {
        Assert.assertEquals("Числа равны", Comparison.compare(26, 26));
    }
}