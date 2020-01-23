package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    private WebDriver driver;
    final private static String PAGE_URL = "https://www.neweracap.com/";

    @FindBy(how = How.XPATH, using = "//a[@href='/login']")
    private WebElement registerButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
