
pipeline {
    agent any
    environment {
        TEST_USERNAME = 'standard_user'
        TEST_PASSWORD = 'secret_sauce'
    }


    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Environment') {
            steps {
                sh '''
                    java -version
                    mvn -version
                '''
            }
        }

        stage('Install Playwright Browser') {
            steps {
                sh '''
                    mvn exec:java \
                      -Dexec.mainClass=com.microsoft.playwright.CLI \
                      -Dexec.args="install chromium"
                '''
            }
        }

        stage('Run Playwright Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts:
                'target/cucumber-reports/**/*,target/surefire-reports/**/*',
                allowEmptyArchive: true

            junit testResults:
                'target/surefire-reports/*.xml',
                allowEmptyResults: true
        }

        success {
            echo 'Playwright execution completed successfully!'
        }

        failure {
            echo 'Playwright execution failed. Check test reports.'
        }
    }
}
