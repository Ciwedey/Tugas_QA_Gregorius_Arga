package org.automationexercise.context;

import org.openqa.selenium.WebDriver;

// Context object to allow data sharing across different step definition classes in Cucumber.
public class ScenarioContext {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}