package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;


public class LoginPage {
    protected WebDriver driver;

    //Existed user login
    @FindBy(id = "j_username")
    protected WebElement userName;

    @FindBy (id = "j_password")
    protected WebElement password;

    @FindBy(id = "loginFormBtn")
    protected WebElement loginButton;

    @FindBy(className= "forgotten-password")
    protected WebElement forgotPassword;

    //Register new user
    @FindBy(id = "register.firstName")
    protected WebElement registerFirstName;

    @FindBy(id = "register.lastName")
    protected WebElement registerLastName;

    @FindBy(id = "register.email")
    protected WebElement registerEmail;

    @FindBy (id = "password")
    protected WebElement registerPassword;

    @FindBy(id="register.checkPwd")
    protected  WebElement confirmPassword;

    @FindBy (id="registerFormBtn")
    protected WebElement confirmRegistrationButton;

    @FindBy (xpath = "/html/body/main/div[2]/div[1]/div/p")
    protected WebElement errorMessage;

    public LoginPage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginBtn () {
        loginButton.click();
    }

    public void inputDataUserLogin (String email, String inputPassword) {
        userName.sendKeys(email);
        password.sendKeys(inputPassword);
    }

    public void inputRegisterUserData (HashMap <String, String> dataUser) {
        registerFirstName.sendKeys(dataUser.get("First Name"));
        registerLastName.sendKeys(dataUser.get("Last Name"));
        registerEmail.sendKeys(dataUser.get("Email"));
        registerPassword.sendKeys(dataUser.get("Password"));
        confirmPassword.sendKeys(dataUser.get("Password"));
    }

    public void clickSubmitRegister () {
        confirmRegistrationButton.click();
    }

    public boolean errorLoginDisplay () {
        return errorMessage.getText().contains("Your username or password was incorrect.");
    }

    public boolean errorRegistrationDisplay () {
        return errorMessage.getText().contains("Please correct the errors below.");
    }

}
