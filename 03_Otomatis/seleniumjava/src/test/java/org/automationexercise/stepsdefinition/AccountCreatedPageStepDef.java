package org.automationexercise.stepsdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automationexercise.context.ScenarioContext;
import org.automationexercise.pages.AccountCreatedPage;
import org.automationexercise.pages.HomePage;
import org.testng.Assert;

public class AccountCreatedPageStepDef {
    private final ScenarioContext context;
    private AccountCreatedPage accountCreatedPage;
    private HomePage homePage;

    // Constructor Parameter
    public AccountCreatedPageStepDef(ScenarioContext context) {
        this.context = context;
    }

    // Account Created page step definition
    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        // initialize signupPage if null
        if (accountCreatedPage == null) {
            accountCreatedPage = new AccountCreatedPage(context.getDriver());
        }
        // Check success message is correct
        String headerText = accountCreatedPage.getHeaderText();
        Assert.assertEquals(headerText, message);

        accountCreatedPage.getCongratulationsText();
    }

    @Then("I should see a Continue button")
    public void i_should_see_a_continue_button() {
        Assert.assertTrue(accountCreatedPage.checkContinueButton());
    }

    @When("I click the Continue button")
    public void i_click_the_continue_button() {
        accountCreatedPage.clickContinueButton();
        homePage = new HomePage(context.getDriver());
    }

    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        String url = homePage.getHomePageUrl();
        String pageTitle = homePage.getHomePageTitle();

        Assert.assertEquals(url, "https://www.automationexercise.com/");
        Assert.assertEquals(pageTitle, "Automation Exercise");
        Assert.assertTrue(homePage.checkLogoutButton());
    }
}

