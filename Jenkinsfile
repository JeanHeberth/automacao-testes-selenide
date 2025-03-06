pipeline {
    agent any

    environment {
        BROWSER = 'chrome'
        TEST_URL = 'https://www.demoblaze.com/'
    }

    stages {
        stage('Checkout Código') {
            steps {
                git branch: 'main', url: 'https://github.com/JeanHeberth/automacao-testes-selenide.git'
            }
        }

        stage('Baixar Dependências') {
            steps {
                sh './gradlew dependencies'
            }
        }

        stage('Executar Testes') {
            steps {
                sh './gradlew clean test'
            }
        }

        }
    }

