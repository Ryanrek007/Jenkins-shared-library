def world(){
    echo "Hello World"
}

def post(){
    if (currentBuild.currentResult == 'SUCCESS') {
        echo "Building Success"
        slackSend (
            channel: "#jenkins-notification", 
            color: "good", 
            message: 
            "*${currentBuild.currentResult}:* Job #${env.BUILD_NUMBER} '${env.JOB_NAME}' on branch ${env.BRANCH_NAME}\
            \n${env.BUILD_URL}"
    )
    } else if (currentBuild.currentResult == 'FAILURE') {
        echo "Building Failed"
        slackSend (
            channel: "#jenkins-notification", 
            color: "danger", 
            message: 
            "*${currentBuild.currentResult}:* Job #${env.BUILD_NUMBER} '${env.JOB_NAME}' on branch ${env.BRANCH_NAME}\
            \n${env.BUILD_URL}"
        )
    }
}