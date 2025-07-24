package org.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

    private final WebDriver driver;

    // Locator
    private final By genderMrLocator = By.xpath("//input[@id=\"id_gender1\"]");
    private final By genderMrsLocator = By.xpath("//input[@id=\"id_gender2\"]");
    private final By nameLocator = By.xpath("//input[@id=\"name\"]");
    private final By passwordLocator = By.xpath("//input[@id=\"password\"]");
    private final By dayOfBirthLocator = By.xpath("//select[@id=\"days\"]");
    private final By monthOfBirthLocator = By.xpath("//select[@id=\"months\"]");
    private final By yearOfBirthLocator = By.xpath("//select[@id=\"years\"]");
    private final By firstNameAddressLocator = By.xpath("//input[@id=\"first_name\"]");
    private final By lastNameAddressLocator = By.xpath("//input[@id=\"last_name\"]");
    private final By detailAddressLocator = By.xpath("//input[@id=\"address1\"]");
    private final By countryLocator = By.xpath("//select[@id=\"country\"]");
    private final By stateCountryLocator = By.xpath("//input[@id=\"state\"]");
    private final By cityLocator = By.xpath("//input[@id=\"city\"]");
    private final By zipcodeLocator = By.xpath("//input[@id=\"zipcode\"]");
    private final By phoneLocator = By.xpath("//input[@id=\"mobile_number\"]");
    private final By submitLocator = By.xpath("//button[@data-qa=\"create-account\"]");

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page methods or page action
    public void selectGenderMr() {
        driver.findElement(genderMrLocator).click();
    }

    public String getSignupPageUrl() {
        String Url = driver.getCurrentUrl();
        System.out.println("Sign up page URL: " + Url);
        return Url;
    }

    public String getSignupPageTitle() {
        String Title = driver.getTitle();
        System.out.println("Sign up page title: " + Title);
        return Title;
    }

    public void selectGenderMrs() {
        driver.findElement(genderMrsLocator).click();
    }

    public void inputName (String name) {
        driver.findElement(nameLocator).sendKeys(name);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void selectDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        driver.findElement(dayOfBirthLocator).sendKeys(dayOfBirth);
        driver.findElement(monthOfBirthLocator).sendKeys(monthOfBirth);
        driver.findElement(yearOfBirthLocator).sendKeys(yearOfBirth);
        System.out.println("Input date of birth: " + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth);
    }

    public void inputAddressName(String firsName, String lastName) {
        driver.findElement(firstNameAddressLocator).sendKeys(firsName);
        driver.findElement(lastNameAddressLocator).sendKeys(lastName);
    }

    public void inputAddressDetail(String detailAddress) {
        driver.findElement(detailAddressLocator).sendKeys(detailAddress);
    }

    public void selectCountry(String country) {
        driver.findElement(countryLocator).sendKeys(country);
    }

    public void selectStateCountry(String state) {
        driver.findElement(stateCountryLocator).sendKeys(state);
    }

    public void selectCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void selectZipcode(String zipcode) {
        driver.findElement(zipcodeLocator).sendKeys(zipcode);
    }

    public void selectPhoneNumber(String phoneNumber) {
        driver.findElement(phoneLocator).sendKeys(phoneNumber);
    }

    public void submitCreateAccount() {
        // Example of explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(submitLocator)).isDisplayed()) {
            driver.findElement(submitLocator).click();
        }
    }

}
