# E-Commerce Test Automation Framework

[![E-Commerce Automation CI](https://github.com/sam-alamdari/e-commerce-automation-framework/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/sam-alamdari/e-commerce-automation-framework/actions/workflows/ci.yml)

A Java-based test automation framework for an e-commerce application, covering UI, API, database, and BDD testing.

The project is built with Selenium WebDriver, TestNG, REST Assured, Cucumber, Maven, MySQL, Jenkins, GitHub Actions, and Allure, using the Page Object Model (POM) design pattern.

## Project Overview

This project demonstrates the design and implementation of a structured test automation framework for common e-commerce workflows.

The framework includes automated testing for:

- Web UI workflows
- REST API endpoints
- MySQL database validation
- BDD scenarios with Cucumber
- Smoke and regression test execution
- Data-driven testing
- Failure screenshot capture
- Allure reporting
- Jenkins CI/CD
- GitHub Actions CI

The framework uses centralized configuration and supports Maven system property overrides for configurable test execution.

## Tech Stack

| Technology | Purpose |
| --- | --- |
| Java 21 | Programming language |
| Selenium WebDriver | Web UI automation |
| TestNG | Test execution, assertions, groups, and DataProvider |
| REST Assured | REST API testing |
| Cucumber | BDD test scenarios |
| Maven | Build and dependency management |
| MySQL | Database validation |
| JDBC | Database connectivity and SQL execution |
| Jenkins | CI/CD pipeline |
| GitHub Actions | Cloud-based CI execution |
| Allure Report | Test reporting and visualization |
| Page Object Model | Test design and maintainability |
| Git / GitHub | Version control and source code management |

## Key Features

- Page Object Model (POM)
- Reusable WebDriver management
- Centralized configuration
- Maven system property overrides
- Explicit waits
- Smoke and regression suites
- Data-driven testing with TestNG DataProvider
- BDD scenarios with Cucumber
- REST API testing
- MySQL database validation
- Secure database password handling through environment variables and CI credentials
- Automatic screenshot capture on UI test failure
- Allure test reporting
- Jenkins parameterized pipeline
- GitHub Actions continuous integration
- Headless Chrome execution for CI environments
- Test report and artifact publishing

## Automated Test Coverage

### UI Testing

The UI automation layer covers common e-commerce workflows including:

- Base URL validation
- WebDriver initialization
- Login link validation
- Login form validation
- Successful login
- Invalid login scenarios
- Sign-up modal validation
- Successful user registration
- Product information validation
- Add product to cart
- Checkout form validation
- Purchase confirmation validation

### API Testing

REST Assured is used to validate REST API behavior.

Current API coverage includes:

- Retrieve product details
- Retrieve product list
- Validate query parameters
- Create product
- Update product
- Delete product
- Invalid product ID validation
- Product search with no results
- HTTP status code validation
- JSON response body validation

### Database Testing

The framework includes MySQL database validation using JDBC.

Current database coverage includes:

- Database connection validation
- Product record validation
- Product name validation
- Product price validation
- Product category validation
- Product count validation

Parameterized SQL queries are executed using `PreparedStatement`.

Database credentials are not stored directly in the source code. The database password is supplied through the `ECOMMERCE_DB_PASSWORD` environment variable or CI credential management.

### BDD Testing

Cucumber is integrated with the framework for behavior-driven testing.

Current BDD coverage includes:

- Successful login with valid credentials
- Invalid login scenarios using Scenario Outline
- Multiple credential combinations using Examples
- Smoke and regression tags

## Framework Architecture

The framework separates test responsibilities across dedicated packages.

Main components include:

- `ConfigReader` - centralized configuration management
- `DriverFactory` - WebDriver initialization and cleanup
- `BaseTest` - common TestNG setup and teardown
- `pages` - Page Object Model classes
- `tests` - UI TestNG test classes
- `api` - REST Assured API tests
- `database` - MySQL database tests
- `data` - reusable test data and DataProviders
- `steps` - Cucumber step definitions and hooks
- `runner` - Cucumber TestNG runner
- `listeners` - TestNG listener and failure handling
- `utils` - waits, screenshots, alerts, database access, test-data generation, and reusable workflows

## Project Structure

```text
ECommerceAutomationFramework
|
|-- .github
|   `-- workflows
|       `-- ci.yml
|
|-- Jenkinsfile
|-- pom.xml
|-- README.md
|
`-- src
    |-- main
    |   |-- java
    |   |   `-- com.sam.automation
    |   |       |-- config
    |   |       |   `-- ConfigReader.java
    |   |       `-- driver
    |   |           `-- DriverFactory.java
    |   |
    |   `-- resources
    |       `-- config.properties
    |
    `-- test
        |-- java
        |   `-- com.sam.automation
        |       |-- api
        |       |   |-- ApiBaseTest.java
        |       |   |-- ApiCrudTest.java
        |       |   |-- ApiNegativeTest.java
        |       |   `-- ApiSmokeTest.java
        |       |
        |       |-- base
        |       |   `-- BaseTest.java
        |       |
        |       |-- data
        |       |   |-- CheckoutData.java
        |       |   |-- LoginTestData.java
        |       |   `-- TestData.java
        |       |
        |       |-- database
        |       |   |-- DatabaseConnectionTest.java
        |       |   `-- ProductDatabaseTest.java
        |       |
        |       |-- listeners
        |       |   `-- TestListener.java
        |       |
        |       |-- pages
        |       |   |-- CartPage.java
        |       |   |-- CheckoutPage.java
        |       |   |-- HomePage.java
        |       |   |-- LoginPage.java
        |       |   |-- OrderConfirmationPage.java
        |       |   |-- ProductPage.java
        |       |   `-- SignUpPage.java
        |       |
        |       |-- runner
        |       |   `-- CucumberRunnerTest.java
        |       |
        |       |-- steps
        |       |   |-- Hooks.java
        |       |   `-- LoginSteps.java
        |       |
        |       |-- tests
        |       |   |-- AddToCartTest.java
        |       |   |-- BaseUrlTest.java
        |       |   |-- CheckoutPageTest.java
        |       |   |-- ConfigReaderTest.java
        |       |   |-- DriverFactoryTest.java
        |       |   |-- HomePageTest.java
        |       |   |-- LoginPageTest.java
        |       |   |-- ProductPageTest.java
        |       |   `-- SignUpPageTest.java
        |       |
        |       `-- utils
        |           |-- AlertUtils.java
        |           |-- DatabaseUtils.java
        |           |-- ECommerceFlow.java
        |           |-- ScreenshotUtils.java
        |           |-- TestDataGenerator.java
        |           `-- WaitUtils.java
        |
        `-- resources
            |-- allure.properties
            |-- features
            |   `-- login.feature
            `-- suites
                |-- regression-suite.xml
                `-- smoke-suite.xml
```

## Configuration

The main test configuration is stored in:

```text
src/main/resources/config.properties
```

The framework supports configurable values including:

- Browser
- Base URL
- Headless execution
- Implicit wait
- Explicit wait

Configuration values can also be overridden using Maven system properties.

Example:

```bash
mvn test "-Dbrowser=chrome" "-Dheadless=true"
```

## Running the Tests

Run the complete test suite:

```bash
mvn clean test
```

Run the Smoke suite:

```bash
mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/suites/smoke-suite.xml"
```

Run the Regression suite:

```bash
mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/suites/regression-suite.xml"
```

Run Smoke tests in headless Chrome:

```bash
mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/suites/smoke-suite.xml" "-Dbrowser=chrome" "-Dheadless=true"
```

## Database Test Configuration

Database tests require the database password to be provided through the `ECOMMERCE_DB_PASSWORD` environment variable.

PowerShell example:

```powershell
$env:ECOMMERCE_DB_PASSWORD = "your-database-password"
mvn clean test
```

Do not commit database passwords or other secrets to the repository.

Jenkins uses credential management to provide the database password securely during pipeline execution.

## Smoke and Regression Suites

Dedicated TestNG XML suites are available under:

```text
src/test/resources/suites/
```

The framework contains:

```text
smoke-suite.xml
regression-suite.xml
```

These suites allow targeted execution locally and through CI pipelines.

## Jenkins CI/CD

The repository includes a parameterized Jenkins pipeline defined in:

```text
Jenkinsfile
```

The pipeline supports:

- Source code checkout
- Maven build
- Full test execution
- Smoke suite execution
- Regression suite execution
- Browser selection
- Headless execution configuration
- Base URL configuration
- Secure Jenkins credential injection
- JUnit result publishing
- Allure report generation
- Test artifact archiving

The `TEST_SUITE` parameter supports:

```text
ALL
SMOKE
REGRESSION
```

## GitHub Actions CI

GitHub Actions is configured through:

```text
.github/workflows/ci.yml
```

The workflow runs the Smoke suite automatically on:

- Pushes to the `master` branch
- Pull requests targeting the `master` branch

The workflow:

1. Checks out the repository
2. Configures Java 21
3. Uses Maven dependency caching
4. Executes Smoke tests in headless Chrome
5. Uploads test reports, Allure results, and failure screenshots as workflow artifacts

This provides an additional cloud-based CI execution path alongside Jenkins.

## Allure Reporting

Allure is integrated with the framework for test reporting.

Tests use Allure metadata including:

- Epic
- Feature
- Story
- Severity

Failure screenshots are attached to the corresponding Allure test result when available.

Jenkins also generates and archives the Allure report after test execution.

## Screenshot on Failure

The framework automatically captures screenshots for failed UI tests.

Screenshots are:

- Saved under `target/screenshots`
- Attached to the corresponding Allure result
- Available as Jenkins or GitHub Actions artifacts when generated

## Test Results

Latest documented full Maven test execution:

```text
Tests run: 29
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

Smoke and Regression suites can also be executed independently using their dedicated TestNG XML suite files.

## Project Goal

The goal of this project is to demonstrate practical test automation skills by building and maintaining a complete automation framework across multiple testing layers.

The project combines UI automation, API testing, database validation, BDD, reporting, test organization, and CI/CD practices in a single portfolio project.
