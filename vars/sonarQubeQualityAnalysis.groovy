def call(String sonarTokenName, String sonarQubeProjectName, String sonarQubeProjectKey){
echo "sonarQube analysis start....."
  
  withSonarQubeEnv(credentialsId: "${sonarTokenName}"){
    sh """
    
    "$SONAR_QUBE/bin/sonar-scanner" \
    -Dsonar .projectName=$sonarQubeProjectName \
    -Dsonar .projectKey=$sonarQubeProjectKey \
    -X

    """
  }
  echo "sonarQube analysis complete"
}
