pipeline {
    agent any

    tools {
        jdk 'JDK-25'
        allure 'Allure3'
    }

    stages {
        stage('Checkout') {
            steps {
            bat 'if exist .git (git reset --hard && git clean -fd)'
                checkout scm
            }
        }

        stage('Clean Allure Results') {
            steps {
                bat 'if exist build\\allure-results (rmdir /s /q build\\allure-results)'
            }
        }

        stage('Update Register CSV') {
            steps {
                powershell '''
                    $date = Get-Date -Format "ddMMyyyy"
                    $content = "email,name,password`ncustomer_${date}@test.local,customer_${date},customer_${date}"
                    Set-Content -Path "src/test/resources/register.csv" -Value $content -Encoding Ascii
                    Write-Host "register.csv успешно обновлен. Дата: $date"
                '''
            }
        }

        stage('Run Ordered Tests') {
            steps {
                bat 'gradlew.bat clean allTestsOrder -Dselenide.headless=true'
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