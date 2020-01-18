package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage extends BasePage {

    @FindBy(css = "myAccountLinksHeader")
    private WebElement account;

    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div/p")
    private WebElement messageResult;

    public UserHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean messageRegistrationResult() {
        return messageResult.getText().contains("You have successfully created your account!");
    }
}
