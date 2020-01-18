package com.neweracap.tests;

import com.neweracap.data_generators.DataGenerator;
import com.neweracap.pages.HomePage;
import com.neweracap.pages.LoginPage;
import com.neweracap.pages.UserHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
public class LoginAndPassTest {

    private WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Story("User tries to login the system without data.")
    @Description("Empty data for login")
    public void loginWithEmptyEmailAndPassword() {
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginBtn();
    }

    @Test
    @Story("User tries to register without data.")
    @Description("Test registration with empty data")
    public void registerWithEmptyData() {
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitRegister();
        Assertions.assertTrue(loginPage.errorRegistrationDisplay());
    }

    @Test
    @Story("User tries to register with data.")
    @Description("Test registration with valid data")
    public void registerWithValideData() {
        DataGenerator data = new DataGenerator();
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputRegisterUserData(data.getUserData());
        loginPage.clickSubmitRegister();
        UserHomePage userHome = new UserHomePage(driver);
        Assertions.assertTrue(userHome.messageRegistrationResult());
    }


    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
