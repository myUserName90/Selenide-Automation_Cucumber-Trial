#!groovy

pipeline {
    agent {
        label params.AGENT == "macos" ? "macos" : params.AGENT
    }

    parameters {
        string defaultValue: 'master', description: 'Branch ', name: 'BRANCH', trim: true
    }
    options {
        timestamps()
        ansiColor("xterm")
    }
    stages {
        stage('Clone') {
            steps {
                cleanWs notFailBuild: true
                checkout([
                        $class           : 'GitSCM',
                        branches         : [[name: "${BRANCH}"]],
                        userRemoteConfigs: [[url: "git@gitlab.betconstruct.int:automation_qa/qa_spring_backoffice_ui_automation.git", credentialsId: "gitlab"]]
                ])
            }
        }

        stage("Run") {
            steps {
                script {
                    if (isUnix()) {
                        sh "mvn clean test"
                    } else {
                        bat "mvn clean test"
                    }
                }
            }
            post {
                always {
                    script {
                        allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                        script {
                            if (isUnix()) {
                                sh "mvn allure:aggregate"
                            } else {
                                bat "mvn allure:aggregate"
                            }
                            cleanWs()
                        }
                    }
                }
            }
        }
    }
}