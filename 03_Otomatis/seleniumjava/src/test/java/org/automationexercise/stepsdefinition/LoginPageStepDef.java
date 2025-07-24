package org.automationexercise.stepsdefinition;

import org.automationexercise.context.ScenarioContext;
import org.automationexercise.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

    private final ScenarioContext context;

    // Constructor Parameter
    public LoginPageStepDef(ScenarioContext context) {
        this.context = context;
    }
    private LoginPage loginPage;

    // Login page step definition
    @Given("I am on the AutomationExercise login page")
    public void i_am_on_the_automation_exercise_login_page() {
        context.getDriver().get("https://www.automationexercise.com/login");
        loginPage = new LoginPage(context.getDriver());
    }

    @When("I enter a unique name and valid email address")
    public void i_enter_a_unique_name_and_valid_email_address() {
        if (loginPage == null) {
            loginPage = new LoginPage(context.getDriver());
        }
        loginPage.inputSignupNameAndEmail("John Smith", "jogja.test01@test.id");
    }

    @When("I enter a unique name {string} and valid email address {string}")
    public void i_enter_a_unique_name_and_valid_email_address(String name, String email) {
        if (loginPage == null) {
            loginPage = new LoginPage(context.getDriver());
        }
        loginPage.inputSignupNameAndEmail(name, email);
    }

    @When("I click the Signup button")
    public void i_click_the_signup_button() {
        loginPage.clickSignupButton();
    }

    @When("I login in using email {string} and password {string}")
    public void i_login_in_using_email_and_password(String email, String pwd) {
        if (loginPage == null) {
            loginPage = new LoginPage(context.getDriver());
        }
        loginPage.inputLoginEmail(email);
        loginPage.inputLoginPassword(pwd);
        loginPage.clickLoginButton();

    }

}

