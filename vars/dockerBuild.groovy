def call(String dockerImageName){

      def imageTag = "${dockerImageName}:build-${env.BUILD_NUMBER}"


  echo "build docker image..."
  sh """

  set -e
   docker build -t ${imageTag} . 
   echo "docker image created ${imageTag}"

  

  """
     env.IMAGE_TAG= imageTag

}
