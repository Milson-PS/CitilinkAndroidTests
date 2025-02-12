package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private AndroidDriver driver;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Профиль']")
    private WebElement profileButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='ru.citilink.develop:id/buttonProfileGuestHeaderAuth']")
    private WebElement loginButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='ru.citilink.develop:id/editTextAuthPhone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//android.widget.Button[@resource-id='ru.citilink.develop:id/buttonAuthPhoneGetCode']")
    private WebElement getSmsButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='ru.citilink.develop:id/textViewProfilePhoneInfoCallInfo']")
    private WebElement profilePhoneInfo;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Открытие приложения")
    public void openApp() {
        // Действие для открытия приложения (если требуется)
    }

    @Step("Нажатие на профиль")
    public void clickProfile() {
        profileButton.click();
    }

    @Step("Нажатие на кнопку Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Ввод номера телефона: {0}")
    public void enterPhoneNumber(String phone) {
        phoneInput.sendKeys(phone);
    }

    @Step("Нажатие на кнопку получения SMS")
    public void clickGetSMS() {
        getSmsButton.click();
    }

    @Step("Ввод SMS кода: {0}")
    public void enterSMSCode(String code) {
        // Симуляция ввода кода
    }

    public WebElement getProfilePhoneInfo() {
        return profilePhoneInfo;
    }
}
