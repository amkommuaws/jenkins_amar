// This environment block can be used at pipeline level and stage level
pipeline {
    agent any
    // these env vars can be used across all the stages
    environment {
        // key value pairs
        name = "siva"
        course = "K8S"
    }
    stages {
        stage ('Build') {
            // these env vars are specific to this stage
            environment {
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
            }
        }
        stage ('SecondStage') {
            // these env vars are specific to this stage
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
            }            
        }
    }
}



// Lets test precedence

pipeline {
    agent any
    // these env vars can be used across all the stages
    environment {
        // key value pairs
        name = "siva"
        course = "K8S"
    }
    stages {
        stage ('Build') {
            // these env vars are specific to this stage
            environment {
                cloud = "GCP"
                name = "maha"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
            }
        }
    }
}

// print env
pipeline {
    agent any
    // these env vars can be used across all the stages
    environment {
        // key value pairs
        name = "siva"
        course = "K8S"
    }
    stages {
        stage ('Build') {
            // these env vars are specific to this stage
            environment {
                cloud = "GCP"
                name = "maha"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
                sh "printenv" // it'll populate all the environment variables
            }
        }
    }
}
