pipeline {
    agent any
    stages {
        stage ('Build'){
            steps {
                //https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#timeout-enforce-time-limit
                timeout (time: 2, unit: 'SECONDS') { //Values: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS
                    //timeout block code
                    echo "Sleeping for 60 seconds"
                    sleep 60
                }
            }
        }
    }
}


// try an example with both retry and timeout ?????