// let's write a bit ccomplex one with both input and parameters.
//stage level lo ---> input -----> parameters
pipeline {
    agent any
    stages {
        stage ('Deploy to Dev') {
            steps {
                echo "Deploying to Dev"
            }
        }
        stage ('Deploy to Prod') {
            options {
                timeout(time: 60, unit: 'SECONDS')
            }
            input {
                message "Shloud we continue"
                ok "Approved"
                submitter "nani" //we have 2 users amkommu, nani .... By default admins can approve no need to provide the name here
                submitterParameter "WhoApproved"
                parameters {
                    string(name: 'CHANGE_TICKET', defaultValue: 'CH12345', description: 'Please Enter Change Ticket Number')
                    booleanParam(name: 'SRE Approved ???', defaultValue: true, description: 'Is approval taken from SRE')
                    choice(name: 'Release', choices: 'Regular\nHotfix', description: 'What Type of Release is this')
                    text(name: 'Notes', defaultValue: 'Enter release notes if any....', description: 'Release Notes')
                    password(name: 'myPassword', defaultValue: 'myPasswordValue', description: 'Enter the Password')
                    credentials(name: 'myCredentials', description: 'My Credentials', required: true)
                }
            }
            steps {
                echo "The Change Ticket is ${CHANGE_TICKET}"
                echo "Deploying to Production"
                echo "This is a ${Release} Release"
                echo "Approved by ${WhoApproved}"
            }
        }
    }
}

// if you use parameters in pipeline level use>>> params.NAME
// stage >> input >> >>> parameters use>>> NAME