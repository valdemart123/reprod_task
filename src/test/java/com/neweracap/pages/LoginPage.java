package com.neweracap.pages;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //Existed user login
    @FindBy(id = "j_username")
    private WebElement userName;
    @FindBy(id = "j_password")
    private WebElement password;
    @FindBy(id = "loginFormBtn")
    private WebElement loginButton;
    @FindBy(className = "forgotten-password")
    private WebElement forgotPassword;
    //Register new user
    @FindBy(id = "register.firstName")
    private WebElement registerFirstName;
    @FindBy(id = "register.lastName")
    private WebElement registerLastName;
    @FindBy(id = "register.email")
    private WebElement registerEmail;
    @FindBy(id = "password")
    private WebElement registerPassword;
    @FindBy(id = "register.checkPwd")
    private WebElement confirmPassword;
    @FindBy(id = "registerFormBtn")
    private WebElement confirmRegistrationButton;
    @FindBy(xpath = "//p[@class='alert-plain-message']")
    protected WebElement errorMessage;
    @FindBy(css = "myAccountLinksHeader")
    private WebElement account;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnLoginBtn() {
        loginButton.click();
    }

    public void inputDataUserLogin(String email, String inputPassword) {
        userName.sendKeys(email);
        password.sendKeys(inputPassword);
    }

    public void inputRegisterUserData() {
        Faker faker = new Faker();
        registerFirstName.sendKeys(faker.firstName());
        registerLastName.sendKeys(faker.lastName());
        registerEmail.sendKeys(faker.bothify("????##@yopmail.com"));
        registerPassword.sendKeys("P@ssword123##");
        confirmPassword.sendKeys("P@ssword123##");
    }

    public void clickSubmitRegister() {
        confirmRegistrationButton.click();
    }

    /*
    For next using in different tests.
    public void errorLoginDisplay() {
        Assertions.assertEquals("Your username or password was incorrect.", errorMessage.getText());
    }*/

    public void errorRegistrationDisplay() {
        Assertions.assertEquals("Please correct the errors below.", errorMessage.getText());
    }
    public void completeRegistrationDisplay() {
        Assertions.assertEquals("You have successfully created your account!", errorMessage.getText());
    }
}
