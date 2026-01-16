def call(){
  eecho "checking sonarqube gates..."
  timeout(time: 10, unit: "MINUTES"){
    waitForQualityGate abortPipeline: false
    
  }
  echo "SonarQube gates checks complete successfully"
}
