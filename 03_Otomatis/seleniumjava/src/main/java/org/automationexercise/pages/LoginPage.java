package org.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    // Locator
    private final By loginEmailLocator = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginPasswordLocator = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By signUpNameLocator = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By signUpEmailLocator = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By loginButtonLocator = By.xpath("//button[@data-qa=\"login-button\"]");
    private final By signUpButtonLocator = By.xpath("//button[@data-qa=\"signup-button\"]");

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Page methods or action
    public String getLoginPageUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("Login page Url: " + url);
        return url;
    }

    public void inputSignupNameAndEmail(String name, String email) {
        driver.findElement(signUpNameLocator).sendKeys(name);
        driver.findElement(signUpEmailLocator).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signUpButtonLocator).click();
    }

    public void inputLoginEmail(String email) {
        driver.findElement(loginEmailLocator).sendKeys(email);
    }

    public void inputLoginPassword(String password) {
        driver.findElement(loginPasswordLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

}
