pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                echo "Executing Multi Branch Pipeline"
            }
        }
        stage ('test') {
            steps {
                echo "Executing test stage"
            }
        }
        stage ('deploytodev') {
            steps {
                echo "Executing Dev deployment stage"
            }
        }
        stage ('depolytoprod') {
            steps {
                echo "Executing Prod deployment stage"
            }
        }

    }
}