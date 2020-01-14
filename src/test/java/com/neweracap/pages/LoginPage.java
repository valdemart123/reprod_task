package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private WebDriver driver;

    //Existed user login
    @FindBy(id = "j_username")
    private WebElement userName;

    @FindBy (id = "j_password")
    private WebElement password;

    @FindBy(id = "loginFormBtn")
    private WebElement loginButton;

    @FindBy(className= "forgotten-password")
    private WebElement forgotPassword;

    //Register new user
    @FindBy(id = "register.firstName")
    private WebElement registerFirstName;

    @FindBy(id = "register.lastName")
    private WebElement registerLastName;

    @FindBy(id = "register.email")
    private WebElement registerEmail;

    @FindBy (id = "password")
    private WebElement registerPassword;

    @FindBy(id="register.checkPwd")
    private  WebElement confirmPassword;

    @FindBy (id="registerFormBtn")
    private WebElement confirmRegistrationButton;

    @FindBy (linkText = "Your username or password was incorrect.")
    private WebElement errorLogin;

    @FindBy (linkText = "Please correct the errors below.")
    private WebElement errorRegistration;

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

    public void inputRegisterUserData (String inputFName, String inputLName, String inputPass, String inputConPass,
                                       String inputEmail) {
        registerFirstName.sendKeys(inputFName);
        registerLastName.sendKeys(inputLName);
        registerEmail.sendKeys(inputEmail);
        registerPassword.sendKeys(inputPass);
        confirmPassword.sendKeys(inputConPass);
    }

    public void clickSubmitRegister () {
        confirmRegistrationButton.click();
    }

    public boolean errorLoginDisplay () {
        return errorLogin.getText().toString().contains("Your username or password was incorrect.");
    }

    public boolean errorRegistrationDisplay () {
        return errorLogin.getText().toString().contains("Please correct the errors below.");
    }


}
