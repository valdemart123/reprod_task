package com.neweracap.tests;

import com.neweracap.data_generators.DataGenerator;
import com.neweracap.pages.HomePage;
import com.neweracap.pages.LoginPage;
import com.neweracap.pages.UserHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndPassTest {

    private WebDriver driver;

    @BeforeEach
    public void setupDriver () {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public  void loginWithEmptyEmailAndPassword () {
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginBtn();
        Assertions.assertTrue(loginPage.errorLoginDisplay());
    }

    @Test
    public void registerWithEmptyDatas () {
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitRegister();
        Assertions.assertTrue(loginPage.errorRegistrationDisplay());
    }

    @Test
    public void registerWithValideData () {
        DataGenerator data = new DataGenerator();
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputRegisterUserData(data.getUserData());
        loginPage.clickSubmitRegister();
        UserHomePage userHome = new UserHomePage(driver);
        Assertions.assertTrue(userHome.messageRegistrationResult());
    }
}
