pipeline {

    agent any

    options {
        skipDefaultCheckout(true)
    }

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    environment {
        ECOMMERCE_DB_PASSWORD = credentials('ecommerce-db-password')
        ECOMMERCE_TEST_PASSWORD = credentials('ecommerce-test-password')
    }

    parameters {

        choice(
            name: 'TEST_SUITE',
            choices: ['ALL', 'SMOKE', 'REGRESSION'],
            description: 'Select the test suite to execute'
        )

        choice(
            name: 'BROWSER',
            choices: ['chrome'],
            description: 'Select the browser for test execution'
        )

        choice(
            name: 'HEADLESS',
            choices: ['true', 'false'],
            description: 'Run browser in headless mode'
        )

        string(
            name: 'BASE_URL',
            defaultValue: 'https://www.demoblaze.com',
            description: 'Base URL for test execution'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('All Tests') {
            when {
                expression {
                    params.TEST_SUITE == 'ALL'
                }
            }

            steps {
                bat 'mvn test "-Dbrowser=%BROWSER%" "-Dheadless=%HEADLESS%" "-DbaseUrl=%BASE_URL%"'
            }
        }

        stage('Smoke Tests') {
            when {
                expression {
                    params.TEST_SUITE == 'SMOKE'
                }
            }

            steps {
                bat 'mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/suites/smoke-suite.xml" "-Dbrowser=%BROWSER%" "-Dheadless=%HEADLESS%" "-DbaseUrl=%BASE_URL%"'
            }
        }

        stage('Regression Tests') {
            when {
                expression {
                    params.TEST_SUITE == 'REGRESSION'
                }
            }

            steps {
                bat 'mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/suites/regression-suite.xml" "-Dbrowser=%BROWSER%" "-Dheadless=%HEADLESS%" "-DbaseUrl=%BASE_URL%"'
            }
        }
    }

    post {

        always {

            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            archiveArtifacts(
                artifacts: 'target/cucumber-reports/**, target/screenshots/**',
                allowEmptyArchive: true
            )

            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}
