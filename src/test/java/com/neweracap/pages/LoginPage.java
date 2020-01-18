package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;


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
    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div/p")
    private WebElement errorMessage;

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

    public void inputRegisterUserData(HashMap<String, String> dataUser) {
        registerFirstName.sendKeys(dataUser.get("First Name"));
        registerLastName.sendKeys(dataUser.get("Last Name"));
        registerEmail.sendKeys(dataUser.get("Email"));
        registerPassword.sendKeys(dataUser.get("Password"));
        confirmPassword.sendKeys(dataUser.get("Password"));
    }

    public void clickSubmitRegister() {
        confirmRegistrationButton.click();
    }

    public boolean errorLoginDisplay() {
        return errorMessage.getText().contains("Your username or password was incorrect.");
    }

    public boolean errorRegistrationDisplay() {
        return errorMessage.getText().contains("Please correct the errors below.");
    }

}
