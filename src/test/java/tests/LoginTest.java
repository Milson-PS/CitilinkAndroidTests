package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverManager;

import java.time.Duration;

@Listeners({AllureTestNg.class})
@Epic("Авторизация в приложении")
public class LoginTest {

    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        DriverManager.initDriver();
        loginPage = new LoginPage(DriverManager.getDriver());
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    @Test
    @Feature("Вход в аккаунт")
    @Description("Проверяем, что пользователь может войти с валидными данными")
    public void testLogin() {
        loginPage.openApp();
        loginPage.clickProfile();
        loginPage.clickLoginButton();
        loginPage.enterPhoneNumber("79351111360");
        loginPage.clickGetSMS();
        loginPage.enterSMSCode("1111");
        wait.until(ExpectedConditions.visibilityOf(loginPage.getProfilePhoneInfo()));
        Assert.assertTrue(loginPage.getProfilePhoneInfo().isDisplayed(), "Профиль не отобразился");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}