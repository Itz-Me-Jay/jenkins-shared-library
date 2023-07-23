def call(Map stepsParams) {
    // Store Git credentials using the withCredentials block
    withCredentials([usernamePassword(credentialsId: 'my-credentials-id', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
        // Call gitcheckout using "MAP" variables for parameters like branch and URL     
        checkout([
            $class: 'GitSCM',
            branches: [[name: stageParams.branch]],
            userRemoteConfig: [[url: stageParams.url]]
        ])
    }
}
