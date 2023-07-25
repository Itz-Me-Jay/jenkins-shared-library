def call(String project3, String ImageTag, String hubUser){
  
       sh """
        docker image build -t ${hubUser}/${project3} . 
        docker image tag ${hubUser}/${project3} ${hubUser}/${project3}:${ImageTag}
        docker image tag ${hubUser}/${project3} ${hubUser}/${project3}:latest  
       """
  }

/* def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
     docker build -t ${ecr_repoName} .
     docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}
*/
