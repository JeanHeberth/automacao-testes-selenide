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

        stage('Instalar Dependências') {
            steps {
                sh './gradlew dependencies'
            }
        }

        stage('Executar Testes') {
            steps {
                 sh './gradlew clean test'
            }
        }
         stage('Generate Allure Report') {
                    steps {
                        sh './gradlew allureReport'  // Gera os relatórios do Allure
                    }
                }

        stage('Publicar Relatórios') {
            steps {
                allure([
                   results: [[path: 'build/allure-results']],  // Diretório do relatório
                   reportBuildPolicy: ALWAYS
               ])
            }
        }
    }

}
