package org.automationexercise.stepsdefinition;

import java.time.Duration;

import org.automationexercise.context.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private final ScenarioContext context;

    public Hooks(ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver(); // Initialize Chrome, Firefox, webkit, etc
        // Implicit wait in scope of WebDriver instance
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Sets driver timeout when finding element before driver throw exception error
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // Sets the page load timeout, which is the time Selenium will wait for a page to load completely.
        context.setDriver(driver);
    }

    @After
    public void teardown() {
        if (context.getDriver() != null) {
            try {
                Thread.sleep(5000); // Pause before shut down driver in order to debug
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            context.getDriver().quit();
        }
    }
}