package org.automationexercise.stepsdefinition;

import io.cucumber.java.en.Then;
import org.automationexercise.context.ScenarioContext;
import org.automationexercise.pages.AccountCreatedPage;
import org.testng.Assert;

public class AccountCreatedPageStepDef {
    private final ScenarioContext context;
    private AccountCreatedPage accountCreatedPage;

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
}

