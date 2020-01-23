package com.neweracap.tests;

import com.neweracap.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
public class LoginAndPassTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("User tries to login the system without data.")
    @Description("Empty data for login")
    public void loginWithEmptyEmailAndPassword() {
        loginPage.clickOnRegisterButton();
        loginPage.clickOnLoginBtn();
    }

    @Test
    @Story("User tries to register without data.")
    @Description("Test registration with empty data")
    public void registerWithEmptyData() {
        loginPage.clickOnRegisterButton();
        loginPage.clickSubmitRegister();
        loginPage.errorRegistrationDisplay();
    }

    @Test
    @Story("User tries to register with data.")
    @Description("Test registration with valid data")
    public void registerWithValidData() {
        loginPage.clickOnRegisterButton();
        loginPage.inputRegisterUserData();
        loginPage.clickSubmitRegister();
        loginPage.completeRegistrationDisplay();
    }


    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
