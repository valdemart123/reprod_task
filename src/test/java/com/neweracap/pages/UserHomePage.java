package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
    protected WebDriver driver;

    @FindBy(css = "myAccountLinksHeader")
    protected WebElement account;

    @FindBy (xpath = "/html/body/main/div[2]/div[1]/div/p")
    private WebElement messageResult;

    public UserHomePage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean messageRegistrationResult () {
        return messageResult.getText().contains("You have successfully created your account!");
    }
}
