pipeline {
    agent any

    tools {
        maven 'Maven'   // Jenkins me configured Maven name
    }

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/1RVP1/MCP_Automation_Project.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                bat 'mvn clean verify'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.log', fingerprint: true
        }
        success {
            echo 'Build Successful ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}
