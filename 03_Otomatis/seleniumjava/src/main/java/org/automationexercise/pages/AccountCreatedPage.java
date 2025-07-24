package org.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private final WebDriver driver;

    // Locator
    private final By headerLocator = By.xpath("//h2[@data-qa=\"account-created\"]");
    private final By containerMessageLocator = By.xpath("//section[@id=\"form\"]");
    private final By btnContinueLocator = By.xpath("//a[@data-qa=\"continue-button\"]");

    // Constructor
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountCreatedPageUrl() {
        String Url = driver.getCurrentUrl();
        System.out.println("Account created page URL: " + Url);
        return Url;
    }

    public String getAccountCreatedPageTitle() {
        String Title = driver.getTitle();
        System.out.println("Account created page title: " + Title);
        return Title;
    }

    public String getHeaderText() {
        String headertext = driver.findElement(headerLocator).getText();
        System.out.println("Header text: " + headertext);
        return headertext;
    }

    public String getCongratulationsText() {
        String successMessage = driver.findElement(containerMessageLocator).getText();
        System.out.println("Success Message: " + successMessage);
        return successMessage;
    }

    public boolean checkContinueButton() {
        return driver.findElement(btnContinueLocator).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(btnContinueLocator).click();
    }


}
