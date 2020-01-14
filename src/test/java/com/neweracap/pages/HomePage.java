package com.neweracap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    private static String PAGE_URL="https://www.neweracap.com/";
    @FindBy(how = How.XPATH, using = "/html/body/main/header/nav/div[2]/nav/div[1]/div[3]/div[2]/ul/li/a" )
    private WebElement registerButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
