def call(String credId, String dockerImageName) {

    withCredentials([
        usernamePassword(
            credentialsId: credId,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {

        sh """
            echo "Building image: ${dockerImageName}:build-${env.BUILD_NUMBER}"

            docker build -t ${dockerImageName}:build-${env.BUILD_NUMBER} .

            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin

            docker tag ${dockerImageName}:build-${env.BUILD_NUMBER} \
            \$DOCKER_USER/${dockerImageName}:build-${env.BUILD_NUMBER}

            docker push \$DOCKER_USER/${dockerImageName}:build-${env.BUILD_NUMBER}
        """
    }
}



