Feature: New User Registration Success

  Background:
    Given I am on the AutomationExercise home page

  @poc
  Scenario: Validate home page elements
    Then I should see the site logo
    And the page title should be "Automation Exercise"
    And the URL should be "https://www.automationexercise.com/"
    And I should see a visible Login button

  @poc
  Scenario: Navigate to signup page and enter user credentials
    When I click the Login button
    Then the URL should be "https://www.automationexercise.com/login"
    And the page title should be "Automation Exercise - Signup / Login"
    When I enter a unique name "testAgent04" and valid email address "test.agent04@test.org"
    And I click the Signup button
    Then the URL should be "https://www.automationexercise.com/signup"
    And the page title should be "Automation Exercise - Signup"

  @poc
  Scenario: Success register account by fill account and address information
    Given I am on the signup form using name "testAgent04" and email "test.agent04@test.org"
    When I select gender "Mr"
    And I enter a valid password "scurePass1!"
    And I select a valid date of birth using day "03" month "June" year "2003"
    And I fill in address first name "Jhonny" and last name "Walker"
    And I enter a valid address detail "56 Kandahar St, Singapore 198904"
    And I select country "Singapore"
    And I enter state "Default State", city "Kandahar",zip code "198904", and mobile number "81234123419"
    And I click the Create Account button
    Then I should see the message "ACCOUNT CREATED!"
    And I should see a Continue button
    When I click the Continue button
    Then I should be redirected to the home page
    And I see user name info "testAgent04"
    When I click logout button
    Then I should be redirected to the login page
    When I login in using email "test.agent04@test.org" and password "scurePass1!"
    Then I see user name info "testAgent04"
    And I delete account
