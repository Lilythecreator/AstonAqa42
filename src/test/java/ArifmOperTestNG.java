import org.example.ArifmOper;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ArifmOperTestNG {

    @Test(testName = "Проверка суммы")
    void checkSum() {
        Assert.assertEquals(ArifmOper.sum(14,5), 19);
    }

    @Test(testName = "Проверка разности")
    void checkSub() {
        Assert.assertEquals(ArifmOper.sub(14,5), 9);
    }

    @Test(testName = "Проверка умножения")
    void checkMul() {
        Assert.assertEquals( ArifmOper.mul(14,5), 70);
    }

    @Test(testName = "Проверка деления")
    void checkDiv() {
        Assert.assertEquals(ArifmOper.div(14,5), 2.8);
    }

    @Test(expectedExceptions = ArithmeticException.class,testName = "Проверка деления на ноль")
    void checkDivByZero() {
        ArifmOper.div(14, 0);
    }
}