package org.automationexercise.stepsdefinition;

import org.automationexercise.context.ScenarioContext;
import org.automationexercise.pages.AccountCreatedPage;
import org.automationexercise.pages.LoginPage;
import org.automationexercise.pages.SignupPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class SignupPageStepDef {

    private final ScenarioContext context;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;

    public SignupPageStepDef(ScenarioContext context) {
        this.context = context;
    }

    @Given("I am on the signup form using name {string} and email {string}")
    public void i_am_on_the_signup_form_using_name_and_email(String name, String email) {
        // initialize signupPage if null
        if (signupPage == null) {
            signupPage = new SignupPage(context.getDriver());
        }
        // navigate to sign up button
        context.getDriver().navigate().to("https://www.automationexercise.com/login");
        loginPage = new LoginPage(context.getDriver());
        loginPage.inputSignupNameAndEmail(name, email);
        loginPage.clickSignupButton();

    }

    @When("I select gender {string}")
    public void i_select_gender(String gender) {
        String trimmedGender = gender.trim();
        // Action based on input declared in step
        if ("Mr".equalsIgnoreCase(trimmedGender)) {
            signupPage.selectGenderMr();
        } else if ("Mrs".equalsIgnoreCase(trimmedGender)) {
            signupPage.selectGenderMrs();
        } else {
            throw new IllegalArgumentException("Gender input invalid. Please select Mr or Mrs");
        }
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String pwd) {
        signupPage.inputPassword(pwd);
    }

    @When("I select a valid date of birth using day {string} month {string} year {string}")
    public void i_select_a_valid_date_of_birth_using_day_month_year(String day, String month, String year) {
        signupPage.selectDateOfBirth(day, month, year);
    }

    @When("I fill in first name {string} and last name {string}")
    public void i_fill_in_first_name_and_last_name(String firstName, String lastName) {
        signupPage.inputAddressName(firstName, lastName);
    }

    @When("I enter a valid address detail {string}")
    public void i_enter_a_valid_address_detail(String detailAddress) {
        signupPage.inputAddressDetail(detailAddress);
    }

    @When("I enter state {string}, city {string},zip code {string}, and mobile number {string}")
    public void i_enter_state_city_zip_code_and_mobile_number(String state, String city, String zipCode, String phoneNumber) {
        signupPage.selectStateCountry(state);
        signupPage.selectCity(city);
        signupPage.selectZipcode(zipCode);
        signupPage.selectPhoneNumber(phoneNumber);
    }

    @When("I select country {string}")
    public void i_select_country(String string) {
        signupPage.selectCountry(string);
    }

    @When("I click the Create Account button")
    public void i_click_the_create_account_button() {
        signupPage.submitCreateAccount();
        accountCreatedPage = new AccountCreatedPage(context.getDriver());
    }
}
