def call(){

  echo "checking sonarqube container status"
  sh '''

  set +e

  CONTAINER_NAME="sonarqube-server"

  # checks exist or not

  if docker ps --format '{{.Names}}' | grep -w $CONTAINER_NAME > /dev/null; then
  echo "sonarqube container exists"

  # checks if running
  if  docker ps --format '{{.Names}}' | grep -w $CONTAINER_NAME > /dev/null; then
  echo "sonarqube is already running"
 else
   echo "sonarqube exists but not ruuning"
   docker start $CONTAINER_NAME

   fi
   else 
     echo "sonarqube conatiner not found . creating and  starting......"

     docker run  -itd --name $CONTAINER_NAME \
     -p 9000:9000 \
     -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true \
     sonarqube:lts-community
  fi   

  '''
}
