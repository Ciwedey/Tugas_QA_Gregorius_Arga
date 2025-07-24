package org.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;

    // Locators
    private final By loginPageLocator = By.xpath("//a[@href='/login']");
    private final By HomePageLocator = By.xpath("//a[@href='/home']");
    private final By HomePageIconLocator = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Page methods or page action
    public void navigateToLoginPage() {
        driver.findElement(loginPageLocator).click();
    }

    public boolean checkLoginbutton() {
        return driver.findElement(loginPageLocator).isDisplayed();
    }

    public void navigateToHomePage() {
        driver.findElement(HomePageLocator).click();
    }

    public String getHomePageUrl() {
        String Url = driver.getCurrentUrl();
        System.out.println("Home page URL: " + Url);
        return Url;
    }

    public String getHomePageTitle() {
        String Title = driver.getTitle();
        System.out.println("Home page title: " + Title);
        return Title;
    }

    public Boolean checkHomePageIcon() {
        // Example of implementing explicit wait directly in page methods
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean icon = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageIconLocator)).isDisplayed();
        // Boolean icon = driver.findElement(HomePageIconLocator).isDisplayed();
        System.out.println("Home page icon: " + icon);
        return icon;
    }
}
