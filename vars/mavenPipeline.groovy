def call(){
    pipeline{
        agent any
        stages{
            stage("Hello World from Jenkins shared library"){
                steps{
                    echo "Using jenkins Shared library"
                    echo "on dev branch"
                    script{
                        hello.world()
                    }
                }
            }
            stage("Globall Variable"){
                steps{
                    script{
                        echo author()
                        echo author.name()
                        echo author.asal()
                    }
                }
            }
        }
            post{
            always {
                echo "Publish Notification build on Slack"
                script {
                    hello.post()
                    // if (currentBuild.currentResult == 'SUCCESS') {
                    //     echo "Building Success"
                    //     slackSend (
                    //         channel: "#jenkins-notification", 
                    //         color: "good", 
                    //         message: 
                    //         "*${currentBuild.currentResult}:* Job #${env.BUILD_NUMBER} '${env.JOB_NAME}' on branch ${env.BRANCH_NAME}\
                    //         \n${env.BUILD_URL}"
                    //     )
                    // } else if (currentBuild.currentResult == 'FAILURE') {
                    //     echo "Building Failed"
                    //     slackSend (
                    //         channel: "#jenkins-notification", 
                    //         color: "danger", 
                    //         message: 
                    //         "*${currentBuild.currentResult}:* Job #${env.BUILD_NUMBER} '${env.JOB_NAME}' on branch ${env.BRANCH_NAME}\
                    //         \n${env.BUILD_URL}"
                    //     )
                    // }
                }
            }
        }
    }

}