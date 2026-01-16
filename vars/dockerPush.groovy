def call(String credId, String dockerImageName) {

    withCredentials([
        usernamePassword(
            credentialsId: credId,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {

        sh """
            set -e

             SOURCE_IMAGE=${dockerImageName}:build-${env.BUILD_NUMBER}
             TARGET_IMAGE=\$DOCKER_USER/${dockerImageName}:build-${env.BUILD_NUMBER}

            echo "try to dockerHub loging...."
            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
             echo "image tagging"
            docker tag \$SOURCE_IMAGE \$TARGET_IMAGE

            docker push \$TARGET_IMAGE
        """
    }
}




