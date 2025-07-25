# Selenium Java Automation Project

This project is an automated test suite for [AutomationExercise](https://www.automationexercise.com/) using Selenium WebDriver, Cucumber (Gherkin), TestNG, and the Page Object Model (POM) design pattern. Dependency injection is handled via PicoContainer.

---

## 📁 Project Structure

```
seleniumjava/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── automationexercise/
│   │               └── pages/
│   │                   ├── HomePage.java
│   │                   └── LoginPage.java
│   └── test/
│       ├── java/
│       │   └── org/
│       │       └── automationexercise/
│       │           ├── context/
│       │           │   └── ScenarioContext.java
│       │           ├── stepsdefinition/
│       │           │   ├── HomePageStepDef.java
│       │           │   ├── LoginPageStepDef.java
│       │           │   └── Hooks.java
│       │           └── runner/
│       │               └── TestRunner.java
│       └── resources/
│           ├── features/
│           │   └── user_registration.feature
│           └── testng.xml
├── pom.xml
└── README.md
```

---

## 📂 Folder Directory Usage

- **pom.xml**  
  Maven configuration file containing project dependencies and build plugins.

- **src/main/java/org/automationexercise/pages/**  
  Contains Page Object Model (POM) classes. Each class represents a web page and encapsulates its elements and actions (e.g., `HomePage.java`, `LoginPage.java`).

- **src/test/java/org/automationexercise/context/**  
  Contains context classes (e.g., `ScenarioContext.java`) used for sharing data (like WebDriver instances) between step definitions during a scenario.

- **src/test/java/org/automationexercise/stepsdefinition/**  
  Contains Cucumber step definition classes (e.g., `HomePageStepDef.java`, `LoginPageStepDef.java`, `Hooks.java`). These map Gherkin steps to Java code and manage test setup/teardown.

- **src/test/java/org/automationexercise/runner/**  
  Contains the test runner class (`TestRunner.java`) that integrates Cucumber with TestNG and configures test execution. 
  Default cucumber Option:
  - **tags = "@poc"** : Runner execute all scenario with tag @poc.
  - **features = "src/test/resources/features** : execute all .feature file under defined directory.
  - **glue = {"org.automationexercise.stepsdefinition"}** : define step definition file location.
  - **publish = true** : Set enable or disable upload cucumber report

- **src/test/resources/features/**  
  Contains Gherkin feature files (e.g., `user_registration.feature`) that describe test scenarios in plain English.

- **src/test/resources/testng.xml**  
  TestNG suite configuration file (if used for advanced TestNG configuration).

---

## 🚀 Getting Started

### Prerequisites

- Java 8+
- Maven 3.6+
- Chrome browser (or update driver for your browser)

### How to Run

1. **Navigate to the project directory:**
   ```sh
   cd seleniumjava
   ```

2. **Install dependencies:**
   ```sh
   mvn clean install
   ```

3. **Run tests:**
   ```sh
   mvn test
   ```

### How View Report
1. Cucumber online report link will be automatically generated after execution.
2. Cucumber local report in Html generated under **/seleniumjava/target** directory with file name **cucumber-reports.html**

---

## 🧩 Key Technologies

- **Selenium WebDriver**: Browser automation
- **Cucumber**: BDD, Gherkin syntax for feature files
- **TestNG**: Test runner and reporting
- **PicoContainer**: Dependency injection for step definitions and hooks
- **Page Object Model (POM)**: Clean separation of page logic

---

## 📚 Documentation References

- **Selenium WebDriver**  
  [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/webdriver/)  
  Official docs for browser automation, supported drivers, and API usage.

- **Cucumber**  
  [Cucumber Documentation](https://cucumber.io/docs/)  
  Guides for writing Gherkin feature files, step definitions, and using BDD practices.

- **TestNG**  
  [TestNG Documentation](https://testng.org/doc/)  
  Official docs for test configuration, annotations, parallel

---

## 📄 Feature Example

```gherkin
Feature: New User Registration Success

  Background:
    Given I am on the AutomationExercise home page

  @poc
  Scenario: Validate home page elements
    Then I should see the site logo
    And the page title should be "Automation Exercise"
    And the URL should be "https://www.automationexercise.com/"
    And I should see a visible Login button
```

---

## 🤝 Contributing

Feel free to fork and submit pull requests!

---

## 📜