package com.neweracap.tests;

import com.neweracap.pages.HomePage;
import com.neweracap.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CorrectLoginAndPassTest {

    WebDriver driver = new FirefoxDriver();

    @Test
    public  void LoginWithEmptyEmailAndPassword () {
        HomePage home = new HomePage(driver);
        home.clickOnRegisterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginBtn();
        Assertions.assertTrue(loginPage.errorLoginDisplay());
    }
}
