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
    private final By HomePageIconLocator = By.xpath("//img[@src=\"/static/images/home/logo.png\"]");
    private final By logoutBtnLocator = By.xpath("//a[@href=\"/logout\"]");
    private final By loggedUserInfoLocator = By.xpath("//ul[@class='nav navbar-nav']//a/b");
    private final By deleteAccountBtnLocator = By.xpath("//a[@href=\"/delete_account\"]");

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
        System.out.println("Home page icon: " + icon);
        return icon;
    }

    public boolean checkLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator)).isDisplayed();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutBtnLocator).click();
    }

    public String getLoggedUserInfo() {
        String userInfo = driver.findElement(loggedUserInfoLocator).getText();
        System.out.println("Logged as: " + userInfo);
        return userInfo;
    }

    public void clickDeleteAccountButton() {
        driver.findElement(deleteAccountBtnLocator).click();
        System.out.println("Delete account button clicked");
    }
}
