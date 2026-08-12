pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
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

        stage('Smoke Tests') {
            when {
                expression {
                    params.TEST_SUITE == 'ALL' ||
                    params.TEST_SUITE == 'SMOKE'
                }
            }

            steps {
                bat 'mvn test "-Dgroups=smoke" "-Dbrowser=%BROWSER%" "-Dheadless=%HEADLESS%"'
            }
        }

        stage('Regression Tests') {
            when {
                expression {
                    params.TEST_SUITE == 'ALL' ||
                    params.TEST_SUITE == 'REGRESSION'
                }
            }

            steps {
                bat 'mvn test "-Dgroups=regression" "-DexcludedGroups=smoke" "-Dbrowser=%BROWSER%" "-Dheadless=%HEADLESS%"'
            }
        }
    }

    post {

        always {

            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
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