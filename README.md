# E-Commerce Automation Framework

A Java-based UI test automation framework for an e-commerce web application, built with Selenium WebDriver, TestNG, and Maven using the Page Object Model (POM) design pattern.

## 📌 Project Overview

This project demonstrates a structured and reusable UI test automation framework for testing common e-commerce workflows.

The framework currently includes automated tests for user authentication, product interactions, shopping cart functionality, and checkout.

The project also includes CI test execution with Jenkins, automated reporting with Allure, test grouping, data-driven testing, and screenshot capture for failed tests.

## 🛠️ Tech Stack

| Technology | Purpose |
| --- | --- |
| Java | Programming language |
| Selenium WebDriver | Web UI automation |
| TestNG | Test execution, assertions, groups, and DataProvider |
| Maven | Build and dependency management |
| Jenkins | CI pipeline and automated test execution |
| Allure Report | Test reporting and visualization |
| Page Object Model | Test design and maintainability |
| Git | Version control |
| GitHub | Source code management |
| IntelliJ IDEA | Development environment |

## 🧪 Automated Test Coverage

The framework currently covers the following test scenarios:

- Base URL validation
- WebDriver initialization
- Login link validation
- Login form validation
- Successful user login
- Invalid login scenarios using DataProvider
- Sign-up modal validation
- Successful user registration
- Product information validation
- Add product to cart
- Checkout workflow
- Purchase confirmation validation

The current full test suite executes 14 tests, including multiple data-driven invalid login scenarios.

## 🏗️ Framework Design

The project uses the Page Object Model (POM) to separate page interactions from test logic.

Main framework components include:

- `DriverFactory` for WebDriver creation and cleanup
- `ConfigReader` for configuration management
- `BaseTest` for common test setup and teardown
- Page classes for application interactions
- Test classes for test scenarios and assertions
- Data classes for reusable test data
- Utility classes for waits, screenshots, and reusable e-commerce flows
- TestNG listeners for test execution logging and failure handling

## 📂 Project Structure

```text
ECommerceAutomationFramework
│
├── Jenkinsfile
├── pom.xml
├── README.md
│
└── src
    │
    ├── main
    │   ├── java
    │   │   └── com.sam.automation
    │   │       ├── config
    │   │       │   └── ConfigReader.java
    │   │       │
    │   │       └── driver
    │   │           └── DriverFactory.java
    │   │
    │   └── resources
    │       └── config.properties
    │
    └── test
        ├── java
        │   └── com.sam.automation
        │       ├── base
        │       │   └── BaseTest.java
        │       │
        │       ├── data
        │       │   ├── CheckoutData.java
        │       │   ├── LoginTestData.java
        │       │   └── TestData.java
        │       │
        │       ├── listeners
        │       │   └── TestListener.java
        │       │
        │       ├── pages
        │       │   ├── CartPage.java
        │       │   ├── CheckoutPage.java
        │       │   ├── HomePage.java
        │       │   ├── LoginPage.java
        │       │   └── OrderConfirmationPage.java
        │       │
        │       ├── tests
        │       │   ├── BaseUrlTest.java
        │       │   ├── CheckoutPageTest.java
        │       │   ├── ConfigReaderTest.java
        │       │   ├── DriverFactoryTest.java
        │       │   └── LoginPageTest.java
        │       │
        │       └── utils
        │           ├── ECommerceFlow.java
        │           ├── ScreenshotUtils.java
        │           └── WaitUtils.java
        │
        └── resources
```

## ⚙️ Configuration

Test configuration is managed through:

```text
src/main/resources/config.properties
```

The framework supports configuration values such as:

- Browser
- Base URL
- Headless execution
- Wait timeouts

Configuration values can also be overridden using Maven system properties.

Example:

```bash
mvn test "-Dbrowser=chrome" "-Dheadless=true"
```

## ▶️ Running the Tests

Run the complete test suite:

```bash
mvn clean test
```

Run Smoke tests:

```bash
mvn test "-Dgroups=smoke"
```

Run Regression tests excluding Smoke tests:

```bash
mvn test "-Dgroups=regression" "-DexcludedGroups=smoke"
```

Run Smoke tests in headless Chrome:

```bash
mvn test "-Dgroups=smoke" "-Dbrowser=chrome" "-Dheadless=true"
```

## 🔄 Jenkins CI Pipeline

The project includes a Jenkins pipeline for automated test execution.

The pipeline currently includes:

1. Source code checkout
2. Maven build
3. Smoke test execution
4. Regression test execution
5. JUnit test result publishing
6. Allure report generation

The Jenkins pipeline supports configurable parameters for:

- Test suite: `ALL`, `SMOKE`, or `REGRESSION`
- Browser
- Headless execution
- Base URL

This allows different test configurations to be selected directly from Jenkins before starting a build.

## 📊 Allure Reporting

Allure is integrated with the framework to generate test execution reports.

Tests use Allure annotations including:

- Epic
- Feature
- Story
- Severity

Jenkins automatically generates and archives the Allure report after test execution.

## 📸 Screenshot on Failure

The framework automatically captures a screenshot when a test fails.

Failure screenshots are:

- Saved under `target/screenshots`
- Attached to the corresponding Allure test result

This helps provide additional information when investigating failed UI tests.

## 🧪 Data-Driven Testing

TestNG DataProvider is used for data-driven testing.

Invalid login scenarios are executed with multiple sets of test data while keeping the test logic reusable.

Login-specific test data is separated from the test class using `LoginTestData`.

## 🚦 Test Groups

Tests are organized using TestNG groups:

- `smoke`
- `regression`

These groups can be executed independently through Maven or selected through the Jenkins pipeline.

## 📈 Current Project Status

Current automated test execution:

```text
Tests run: 14
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

Current features include:

- Page Object Model
- Reusable WebDriver management
- Explicit waits
- Centralized configuration
- Maven system property overrides
- Smoke and Regression test groups
- Data-driven testing
- Jenkins CI pipeline
- Parameterized Jenkins execution
- Headless browser execution
- JUnit result publishing
- Allure reporting
- Automatic screenshots on test failure
- Reusable test data structure

## 🎯 Project Goal

The goal of this project is to continue building practical QA automation skills by developing a complete test automation framework step by step.

The project will continue to be expanded with additional testing capabilities as part of the development roadmap.