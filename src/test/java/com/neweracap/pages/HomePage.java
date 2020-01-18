package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/main/header/nav/div[2]/nav/div[1]/div[3]/div[2]/ul/li/a" )
    private WebElement registerButton;

    public HomePage(WebDriver driver){super(driver);}

    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
