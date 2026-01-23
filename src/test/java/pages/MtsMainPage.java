package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsMainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    private By rejectCookiesButton =
            By.xpath("//button[contains(text(),'Отклонить')]");

    private By blockTitle =
            By.xpath("//h2[contains(text(),'Онлайн пополнение')]");

    private By detailsLink =
            By.xpath("//*[@id='pay-section']//a[text()='Подробнее о сервисе']");

    // Логотипы
    private By visaLogo = By.xpath("//img[@alt='Visa']");
    private By verifiedVisaLogo = By.xpath("//img[@alt='Verified By Visa']");
    private By masterCardLogo = By.xpath("//img[@alt='MasterCard']");
    private By masterCardSCLogo = By.xpath("//img[@alt='MasterCard Secure Code']");
    private By belcardLogo = By.xpath("//img[@alt='Белкарт']");

    // Выпадающий список услуг
    private By serviceDropdown =
            By.xpath("//div[contains(@class,'select')]");

    private By servicesOption =
            By.xpath("//p[text()='Услуги связи']");
    private By homeInternetOption =
            By.xpath("//p[text()='Домашний интернет']");
    private By installmentOption =
            By.xpath("//p[text()='Рассрочка']");
    private By arrearsOption =
            By.xpath("//p[text()='Задолженность']");

    // Услуги связи

    private By servicesPhone = By.id("connection-phone");
    private By servicesSum = By.id("connection-sum");
    private By servicesEmail = By.id("connection-email");
    private By continueButton =
            By.xpath("//button[contains(text(),'Продолжить')]");

    private By paymentWidget =
            By.xpath("//div[contains(@class,'payment-widget-app__container')]");

    // Домашний интернет

    private By homeInternetPhone = By.id("internet-phone");
    private By homeInternetSum = By.id("internet-sum");
    private By homeInternetEmail = By.id("internet-email");

    // Рассрочка

    private By installmentAccount = By.id("score-instalment");
    private By installmentSum = By.id("instalment-sum");
    private By installmentEmail = By.id("instalment-email");

    // Задолженность

    private By arrearsAccount = By.id("score-arrears");
    private By arrearsSum = By.id("arrears-sum");
    private By arrearsEmail = By.id("arrears-email");

    // Общие методы

    public void rejectCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(rejectCookiesButton)).click();
    }

    public String getBlockTitleText() {
        return driver.findElement(blockTitle).getText();
    }

    public String getDetailsLinkHref() {
        return driver.findElement(detailsLink).getAttribute("href");
    }

    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    public boolean isVerifiedVisaLogoDisplayed() {
        return driver.findElement(verifiedVisaLogo).isDisplayed();
    }

    public boolean isMasterCardLogoDisplayed() {
        return driver.findElement(masterCardLogo).isDisplayed();
    }

    public boolean isMasterCardSCLogoDisplayed() {
        return driver.findElement(masterCardSCLogo).isDisplayed();
    }

    public boolean isBelcardLogoDisplayed() {
        return driver.findElement(belcardLogo).isDisplayed();
    }


    // Переключение услуг

    public void selectCommunicationServices() {
        driver.findElement(serviceDropdown).click();
        driver.findElement(servicesOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(servicesPhone));
    }

    public void selectHomeInternetService() {
        driver.findElement(serviceDropdown).click();
        driver.findElement(homeInternetOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeInternetPhone));
    }

    public void selectInstallmentService() {
        driver.findElement(serviceDropdown).click();
        driver.findElement(installmentOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(installmentAccount));
    }

    public void selectArrearsService() {
        driver.findElement(serviceDropdown).click();
        driver.findElement(arrearsOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsAccount));
    }


    // Услуги связи
    public void fillCommunicationForm(String phone, String sum) {
        driver.findElement(servicesPhone).sendKeys(phone);
        driver.findElement(servicesSum).sendKeys(sum);
        driver.findElement(continueButton).click();
    }

    public void waitForPaymentWidget() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWidget));
    }

    // Домашний интернет
    public String getHomeInternetPhonePlaceholder() {
        return driver.findElement(homeInternetPhone).getAttribute("placeholder");
    }

    public String getHomeInternetSumPlaceholder() {
        return driver.findElement(homeInternetSum).getAttribute("placeholder");
    }

    public String getHomeInternetEmailPlaceholder() {
        return driver.findElement(homeInternetEmail).getAttribute("placeholder");
    }

    // Рассрочка
    public String getInstallmentAccountPlaceholder() {
        return driver.findElement(installmentAccount).getAttribute("placeholder");
    }

    public String getInstallmentSumPlaceholder() {
        return driver.findElement(installmentSum).getAttribute("placeholder");
    }

    public String getInstallmentEmailPlaceholder() {
        return driver.findElement(installmentEmail).getAttribute("placeholder");
    }

    // Задолженность
    public String getArrearsAccountPlaceholder() {
        return driver.findElement(arrearsAccount).getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return driver.findElement(arrearsSum).getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmail).getAttribute("placeholder");
    }

    // Окно оплаты

    private By paymentAmount = By.xpath("//span[contains(@class,'ng-star-inserted') and contains(text(),'BYN')]");
    private By paymentInfo = By.xpath("//span[contains(@class,'ng-star-inserted') and contains(text(),'Оплата:')]");
    private By payButton = By.xpath("//span[contains(@class,'ng-star-inserted') and contains(text(),'Оплатить')]");

    public String getPaymentAmountText() {
        return driver.findElement(paymentAmount).getText().trim();
    }

    public String getPaymentInfoText() {
        return driver.findElement(paymentInfo).getText().trim();
    }

    public String getPayButtonText() {
        return driver.findElement(payButton).getText().trim();
    }
}

