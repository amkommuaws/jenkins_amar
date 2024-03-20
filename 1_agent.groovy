// This is the comment

/*
Multi line comment
*/


// agent
// any: we will execute the pipeline or state with any available agent
// label: Ideally this is a string, which informs our jenkins to run on a particular slave
// none: When we apply none, no global agent will be picked. The individual stage should specify the respective agent, based on their requirments


// 2 *********************************

pipeline {
    agent {
        label 'mvn-slave'
    }
    stages {
        stage ('labelstage') {
            steps {
              // This should give me pvt ip of the mvn-slave
              sh 'hostname -i' 
            }
        }
    }
}


// 3 ***********************************

pipeline {
     // the below agent is at the pipeline level, and applies for all stages
     agent none
     stages {
        stage ('Build') {
            agent {
                node {
                    label 'mvn-slave'
                    customWorkspace "/home/siva/customeSiva"
                }
            }
            steps {
                echo "Hello!!, executing node in agent"
                sh "hostname -i"
                sh "cat imp.txt"
            }
        }   
     }
}


// 4

pipeline {
     // the below agent is at the pipeline level, and applies for all stages
     agent none
     stages {
        stage ('Build') {
            agent {
                node {
                    label 'mvn-slave'
                    customWorkspace "/home/siva/customeSiva"
                }
            }
            steps {
                echo "Hello!!, executing node in agent"
                sh "hostname -i"
                sh "cat imp.txt"
                // sh 'git clone https://github.com/devopswithcloud/spring-petclinic.git'
                git branch: 'main', url: 'https://github.com/devopswithcloud/spring-petclinic.git'
            }
        }   
     }
}















git branch: 'main', url: 'https://github.com/devopswithcloud/spring-petclinic.git'