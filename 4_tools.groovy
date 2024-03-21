pipeline {
    agent any
    tools {
        maven 'Maven3.8.8'
    }
    stages {
        stage ('Maven') {
            steps {
                echo "Welcome to tools example"
                sh "mvn --version"

            }
        }
        stage ('OtherMaven') {
            tools {
                jdk 'JDK17'
            }
            steps {
                echo "Maven version with JDK 17"
                sh "mvn --version"
            }
        }
    }
}