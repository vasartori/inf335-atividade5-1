pipeline {
    agent any

    tools {
        maven "M3"
    }


    stages {
        stage('Build') {
            steps {
                sh "mvn clean package"
                sh "mvn install"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}

