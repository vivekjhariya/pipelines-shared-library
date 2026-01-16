def call(){
  sh "docker run -itd --name sonarqube-server -p 9000:9000 sonarqube:lts-community "
}
