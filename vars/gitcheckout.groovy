def call(Map stepsParams) {
    withCredentials([usernamePassword(credentialsId: 'my-credentials-id', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
// we are calling gitcheckout Using "MAP" "Variable" for parameters like branch and url     
    checkout ([
        $class: 'GitSCM'
        branches: [[name: stageParams.branch]],
        userRemoteConfig: [[ url: staheParams.url]]
    ])
}