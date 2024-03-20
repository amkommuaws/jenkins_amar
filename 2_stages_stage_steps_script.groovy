// script allows us to write custom code in groovy 
// This script block, should be available in steps
// If we are having any complex environment, we can use script under steps block
// script uses groovy as the programming language
pipeline {
    agent any
    stages {
        stage ("Hello") {
           steps {
             echo "Hello!! Mr Siva"
           }
        }
        stage ("Scripted Stage") {
            steps {
                script {
                    def course = "k8s" //static definition
                    if (course == "k8s") {
                        println ("Thanks for enrolling to ${course}")
                    }
                    else 
                        println ("Do enroll!!")
                    // just sleep for 5 seconds
                    sleep 10
                    echo "************** Script block ended *********************"
                }
            }
        }
    }
}