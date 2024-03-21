pipeline {
    agent any
    environment {
        // credentials('id') , this id should be the same from jenkins credentials
        GITHUB_CREDS = credentials('jenkinsGitHubCreds')
    }
    stages {
        stage ('Build') {
            steps {
                echo "GitHub credentials are ${GITHUB_CREDS}"
                echo "User id is : ${GITHUB_CREDS_USR}"
                echo "Password id : ${GITHUB_CREDS_PSW}"

            }
        }
    }
}