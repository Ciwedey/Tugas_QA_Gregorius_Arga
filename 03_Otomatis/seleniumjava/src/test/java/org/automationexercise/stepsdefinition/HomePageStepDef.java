package org.automationexercise.stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.automationexercise.context.ScenarioContext;
import org.automationexercise.pages.HomePage;
import org.automationexercise.pages.LoginPage;
import org.testng.Assert;

public class HomePageStepDef {

    private final ScenarioContext context;
    private HomePage homePage;
    private LoginPage loginPage;

    // Constructor Parameter
    public HomePageStepDef(ScenarioContext context) {
        this.context = context;
    }

    @Given("I am on the AutomationExercise home page")
    public void i_am_on_the_automation_exercise_home_page() {
        context.getDriver().get("https://www.automationexercise.com/");
        homePage = new HomePage(context.getDriver());
    }

    @Then("I should see the site logo")
    public void i_should_see_the_site_logo() {
        Assert.assertTrue(homePage.checkHomePageIcon(), "Home Page icon is NOT displayed");
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        homePage.navigateToLoginPage();
        loginPage = new LoginPage(context.getDriver());
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String pageTitle) {
        Assert.assertEquals(homePage.getHomePageTitle(),pageTitle, "Tittle page not equal to " + pageTitle);
    }

    @Then("the URL should be {string}")
    public void the_url_should_be(String url) {
        Assert.assertEquals(homePage.getHomePageUrl().trim(),url, "Url not equal to " + url);
    }

    @Then("I should see a visible Login button")
    public void i_should_see_a_visible_login_button() {
        Assert.assertTrue(homePage.checkLoginbutton(), "Login button is not exist");
    }

    @Then("I see user name info {string}")
    public void i_see_user_name_info(String expectedUserName) {
        String actualUserName = homePage.getLoggedUserInfo();
        Assert.assertEquals(actualUserName, expectedUserName);
    }

    @When("I click logout button")
    public void i_click_logout_button() {
        homePage.clickLogoutButton();
        loginPage = new LoginPage(context.getDriver());
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        String actualUrl = loginPage.getLoginPageUrl();
        Assert.assertEquals(actualUrl,"https://www.automationexercise.com/login");
        loginPage = new LoginPage(context.getDriver());
    }

    @Then("I delete account")
    public void i_delete_account() {
        homePage.clickDeleteAccountButton();
    }
}
