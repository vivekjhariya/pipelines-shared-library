def call(String credId,String dockerImageName ){
    withCredentials([userPassword(
        credentialsId: "${credId}",
        usernameVariable: "${dockerUser}",
        passwordVariable: "${dockerPass}"
    )]){
        sh '''
        echo "Building image: ${dockerImageName}:build-${env.BUILD_NUMBER}"
        docker build -t ${dockerImageName}:build-${env.BUILD_NUMBER} .
        docker login -u ${dockerUser} -p ${dockerPass}
        docker image tag ${dockerImageName}:build-${env.BUILD_NUMBER} ${dockerUser}/${dockerImageName}:build-${env.BUILD_NUMBER}
        docker push ${dockerUser}/${dockerImageName}:build-${env.BUILD_NUMBER}


        '''
    }

}

