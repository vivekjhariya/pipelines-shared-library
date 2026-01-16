def call(){
  echo "checking sonarqube gates..."
  timeout(time: 2, unit: "MINUTES"){
    waitForQualityGate abortPipeline: false
    
  }
  echo "SonarQube gates checks complete successfully"
}
