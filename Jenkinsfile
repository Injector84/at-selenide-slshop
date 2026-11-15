pipeline {
    agent any

    tools {
        jdk 'JDK-25'
        allure 'Allure3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean Allure Results') {
            steps {
                bat 'if exist build\\allure-results (rmdir /s /q build\\allure-results)'
            }
        }

        stage('Run Ordered Tests') {
            steps {
                bat 'gradlew.bat allTestsOrder -Dselenide.headless=true'
                bat 'dir build'
                bat 'dir build\\allure-results'
            }
        }
    }

    post {
        always {
            allure includeProperties: false,
                   jdk: '',
                   results: [[path: 'build/allure-results']]
        }
    }
}