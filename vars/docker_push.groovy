def call(String Project, String ImageTag, String dockerhubuser){
    withCredentials([usernamePassword('credentialsId':"docker",
                                passwordVariable:"dockerHubPass",
                                usernameVariable:"dockerHubUser")]){
                sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
                sh "docker image tag ${Project}:${ImageTag} ${dockerHubUser}/${Project}:${ImageTag}"
                sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
				}  
}
