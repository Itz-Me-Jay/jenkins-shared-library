def call(String project, String ImageTag, String hubUser){
/*     
        withCredentials([usernamePassword(
             credentialsId: "docker",
             usernameVariable: "USER",
             passwordVariable: "PASS"     )]) 
*/
        withCredentials([string(
             credentialsId: 'dockerhub',
             variable: 'USER',
             passwordVariable: 'PASS'
        )]) {
             sh "docker login -u $USER -p $PASS"
        }        
        sh "docker image push ${hubUser}/${project3}:${ImageTag}"
        sh "docker image push ${hubUser}/${project3}:latest"   
}

/* FOR AWS ECR

def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}
*/
