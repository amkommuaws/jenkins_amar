// when condition, should have atleast one condition 
// https://www.jenkins.io/doc/book/pipeline/syntax/#when

pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages {
        stage ('Deploy') {
            when {
                not {
                    equals expected: 'production' , actual: "${DEPLOY_TO}"
                }
                //equals expected: 18 , actual: currentBuild.number
                //equals expected: 16 , actual: "${BUILD_NUMBER}"
                //environment name: 'DEPLOY_TO', value: 'production'
            }
            steps {
                echo "Deploying"
            }
        }
    }
}

// if the value doesn't matched ---> it'll skip that stage

// Branch based deployment
// For this it should be multi branch pipeline
pipeline {
    agent any
    stages {
        stage ('Buuld') {
            steps {
                echo "Welcome to Build Stage"
            }
        }
        stage ('Deploy to Dev') {
            steps {
                echo "Deploying to dev environment"
            }
        }
        stage ('Deploy to stage') {
            when {
                expression {
                    // This stage should execute with either prod or staging branch
                    BRANCH_NAME ==~ /(production|staging)/
                }
            }
            steps {
                echo "Deploying to stage envirnment"
            }
        }
    }
}


                        //ex: 3 conditions
//allOf (I have group of conditions all should satisfy then only that stage should execute) and 
//anyOf (Any of the 3 conditions satisfied then ill go with anyOf)

//allOf

pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production' //this is static, we shall see abt dynamic in parameters section
    }
    stages {
        stage ('Build') {
            steps {
                echo "Welcome to Build Stage"
            }
        }
        stage ('Deploy to Dev') {
            steps {
                echo "Devploying to Dev environment"
            }
        }
        stage ('Deploy to Stage') {
            when {
               allOf { //every condition should be satisfied
                 //the below all conditions should be satisfied in order for this stage to execute
                 branch 'production'
                 environment name: 'DEPLOY_TO', value: 'production'
               } 
            }
            steps {
                echo "Deploying to Stage environment"
            }
        }
    }
}

// anyOf

pipeline {
    agent any
    environment {
        DEPLOY_TO = 'production' //this is static, we shall see abt dynamic in parameters section
    }
    stages {
        stage ('Build') {
            steps {
                echo "Welcome to Build Stage"
            }
        }
        stage ('Deploy to Dev') {
            steps {
                echo "Devploying to Dev environment"
            }
        }
        stage ('Deploy to Stage') {
            when {
               anyOf { //every condition should be satisfied
                 //any of the below condition can be satisfied for this stage to be executed
                 branch 'production'
                 environment name: 'DEPLOY_TO', value: 'productions'
               } 
            }
            steps {
                echo "Deploying to Stage environment"
            }
        }
    }
}

// I want to execute stage enironment when the branch is release-****

pipeline {
    agent any
    stages {
        stage ('Build') {
            when {
                branch 'release-*'
            }
            steps {
                echo "Deploying to Stage environment"
            }
        }
    }
}


// I want to execute stage enironment when the branch is release-**** and tag in prod only

pipeline {
    agent any
    stages {
        stage ('UAT') {
            when {
                branch 'release-*'
            }
            steps {
                echo "Deploying to Stage environment"
            }
        }
        stage ('prod') {
            when {
                // this stage should execute with tag only
                //buildingTag()
                // tag format: v1.2.3 --> pass
                // v.1.2.3 ---> failes
                //v1.0 ----> fails
                tag pattern: "v\\d{1,2}.\\d{1,2}.\\d{1,2}", comparator: "REGEXP" 
            }
            steps {
                echo "Deploying to production environment"
            }
        }
    }
}
