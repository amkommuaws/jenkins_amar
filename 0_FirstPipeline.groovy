pipeline { // top level field
    agent any
    stages {
        stage ('FirstStage') { //this name can be user friendly but needs to be specfic for the task performing 
           steps {
            echo 'Welcome to First Pipeline!!!'
           }
        }
    }
}