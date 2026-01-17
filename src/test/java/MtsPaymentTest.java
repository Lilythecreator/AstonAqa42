import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsPaymentTest {

    static WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Отклонить')]")))
                .click();
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка названия блока «Онлайн пополнение без комиссии")
    void checkName() {
        WebElement name = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]"));
        String text = name.getText();

        Assertions.assertTrue(text.contains("Онлайн пополнение"));
        Assertions.assertTrue(text.contains("без комиссии"));
    }

    @Test
    @DisplayName("Наличие логотипов платежных систем")
    void paymentLogo() {
        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt='Visa']"));
        Assertions.assertTrue(visaLogo.isDisplayed());

        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        Assertions.assertTrue(verifiedByVisaLogo.isDisplayed());

        WebElement masterCardLogo = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        Assertions.assertTrue(masterCardLogo.isDisplayed());

        WebElement masterCardSCLogo = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
        Assertions.assertTrue(masterCardSCLogo.isDisplayed());

        WebElement belcardLogo = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
        Assertions.assertTrue(belcardLogo.isDisplayed());
    }

    @Test
    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    void checkLink() {
        WebElement link = driver.findElement(By.xpath("//*[@id='pay-section']//a[text()='Подробнее о сервисе']"));

        String href = link.getAttribute("href");
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", href);
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить»")
    void inputInfo() {
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        sumInput.sendKeys("50");

        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]"));
        continueButton.click();

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'payment-widget-app__container')]")));
    }

}


