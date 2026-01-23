package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsMainPage;

public class MtsPaymentTest {

    static WebDriver driver;
    static MtsMainPage mtsMainPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        mtsMainPage = new MtsMainPage(driver);
        mtsMainPage.rejectCookies();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия блока")
    void checkBlockTitle() {
        String text = mtsMainPage.getBlockTitleText();
        Assertions.assertTrue(text.contains("Онлайн пополнение"));
        Assertions.assertTrue(text.contains("без комиссии"));
    }

    @Test
    @DisplayName("Домашний интернет: проверка формы")
    void checkHomeInternetPlaceholders() {

        mtsMainPage.selectHomeInternetService();

        Assertions.assertEquals(
                "Номер абонента",
                mtsMainPage.getHomeInternetPhonePlaceholder()
        );

        Assertions.assertEquals(
                "Сумма",
                mtsMainPage.getHomeInternetSumPlaceholder()
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                mtsMainPage.getHomeInternetEmailPlaceholder()
        );
    }

    @Test
    @DisplayName("Рассрочка: проверка формы")
    void checkInstallmentPlaceholders() {

        mtsMainPage.selectInstallmentService();

        Assertions.assertEquals(
                "Номер счета на 44",
                mtsMainPage.getInstallmentAccountPlaceholder()
        );

        Assertions.assertEquals(
                "Сумма",
                mtsMainPage.getInstallmentSumPlaceholder()
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                mtsMainPage.getInstallmentEmailPlaceholder()
        );
    }

    @Test
    @DisplayName("Задолженность: проверка формы")
    void checkArrearsPlaceholders() {

        mtsMainPage.selectArrearsService();

        Assertions.assertEquals(
                "Номер счета на 2073",
                mtsMainPage.getArrearsAccountPlaceholder()
        );

        Assertions.assertEquals(
                "Сумма",
                mtsMainPage.getArrearsSumPlaceholder()
        );

        Assertions.assertEquals(
                "E-mail для отправки чека",
                mtsMainPage.getArrearsEmailPlaceholder()
        );
    }

    @Test
    @DisplayName("Наличие логотипов платежных систем")
    void paymentLogosDisplayed() {
        Assertions.assertTrue(mtsMainPage.isVisaLogoDisplayed());
        Assertions.assertTrue(mtsMainPage.isVerifiedVisaLogoDisplayed());
        Assertions.assertTrue(mtsMainPage.isMasterCardLogoDisplayed());
        Assertions.assertTrue(mtsMainPage.isMasterCardSCLogoDisplayed());
        Assertions.assertTrue(mtsMainPage.isBelcardLogoDisplayed());
    }

    @Test
    @DisplayName("Ссылка «Подробнее о сервисе»")
    void checkDetailsLink() {
        Assertions.assertEquals(
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                mtsMainPage.getDetailsLinkHref()
        );
    }

    @Test
    @DisplayName("Услуги связи: заполнение формы и проверка виджета оплаты")
    void sendCommunicationServicePayment() {

        mtsMainPage.selectCommunicationServices();

        mtsMainPage.fillCommunicationForm(
                "297777777",
                "50"
        );

        mtsMainPage.waitForPaymentWidget();

        // Проверка суммы
        Assertions.assertEquals(
                "50.00 BYN",
                mtsMainPage.getPaymentAmountText(),
                "Сумма оплаты указана неверно"
        );

        // Проверка информации о платеже
        Assertions.assertEquals(
                "Оплата: Услуги связи\nНомер:375297777777",
                mtsMainPage.getPaymentInfoText(),
                "Информация о платеже указана неверно"
        );

        // Проверка кнопки "Оплатить" с правильной суммой
        Assertions.assertEquals(
                "Оплатить  50.00 BYN",
                mtsMainPage.getPayButtonText(),
                "Текст на кнопке 'Оплатить' неверен"
        );
    }

}
