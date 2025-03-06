pipeline {
    agent any

    environment {
        BROWSER = 'chrome'
        TEST_URL = 'https://www.demoblaze.com/'
    }

    stages {
        stage('Checkout Código') {
            steps {
                git 'https://github.com/JeanHeberth/automacao-testes-selenide.git'
            }
        }

        stage('Instalar Dependências') {
            steps {
                sh './gradlew dependencies'
            }
        }

        stage('Executar Testes') {
            steps {
                sh './gradlew test -Dbrowser=$BROWSER -Dtest.url=$TEST_URL'
            }
        }

        stage('Publicar Relatórios') {
            steps {
                junit '**/build/test-results/test/*.xml'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/build/reports/tests/test/**', fingerprint: true
        }
    }
}
