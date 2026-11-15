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

        stage('Diagnose Workspace') {
                    steps {
                        bat 'dir'
                        bat 'if exist gradlew.bat (echo gradlew.bat FOUND) else (echo gradlew.bat NOT FOUND)'
                        bat 'if exist build.gradle (echo build.gradle FOUND) else (echo build.gradle NOT FOUND)'
                        bat 'if exist settings.gradle (echo settings.gradle FOUND) else (echo settings.gradle NOT FOUND)'
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