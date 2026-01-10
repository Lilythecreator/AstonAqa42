import org.example.NumFactorial;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NumFactorialTestNG {

    @Test(testName = "Факториал нуля")
    void factorialZero() {
        Assert.assertEquals(NumFactorial.factorial(0), 1);

    }

    @Test(testName = "Факториал единицы")
    void factorialOne() {
        Assert.assertEquals(NumFactorial.factorial(1), 1);
    }

    @Test(testName = "Факториал положительного числа")
    void factorialPositiveNum() {
        Assert.assertEquals(NumFactorial.factorial(8), 40320);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, testName = "Факториал отрицательного числа")
    void factorialNegativeNum() {
        NumFactorial.factorial(-5);
    }
}