def call(String dockerHubCreds,String dockerImageName ){
    withCredentials([userPassword(
        credentialsId: "${dockerHubCreds}",
        variableusername: "${dockerUser}",
        variablepassword: "${dockerPass}"
    )]){
        sh '''
        echo "Building image: ${dockerImageName}:build-${env.BUILD_NUMBER}"
        docker build -t ${dockerImageName}:build-${env.BUILD_NUMBER} .
        docker login -u ${dockerUser} -p ${dockerPass}
        docker tag image ${dockerImageName}:build-${env.BUILD_NUMBER} ${dockerUser}/${dockerImageName}:build-${env.BUILD_NUMBER}
        docker push ${dockerUser}/${dockerImageName}:build-${env.BUILD_NUMBER}


        '''
    }
}