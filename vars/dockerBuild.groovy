def call(String dockerImageName){

  echo "build docker image..."
  sh '''

  set -e
   IMAGE_TAG=${dockerImageName}:build-${env.BUILD_NUMBER}
   docker build -t \$IMAGE_TAG . 
   echo "docker image created \$IMAGE_TAG"

  '''
}
