pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                //error("Failing the stage intentionally")
                echo "Building the Application"
            }
        }
    }
    post {
        // This will only execute if the pipeline/stage has a "Success" status
        // with blue/green in UI
        success {
            // you can keep what ever you want.
            // typically we use mailers here
            echo "Post activity ........ Success is Called"
        }
        // This will execute if the pipeline/stage has a "failed" status 
        failure {
            echo "Post activity ........ Failed is Called"
        }
        always {
            // Mail notification is typically used here
            echo "Always Block Triggered "
        }
    }
}