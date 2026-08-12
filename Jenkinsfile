pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
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
            steps {
                bat 'mvn test "-Dgroups=smoke"'
            }
        }

        stage('Regression Tests') {
            steps {
                bat 'mvn test "-Dgroups=regression" "-DexcludedGroups=smoke"'
            }
        }
    }

    post {

        always {

            junit 'target/surefire-reports/*.xml'

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