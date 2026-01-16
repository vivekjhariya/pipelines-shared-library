def call(Map config = [:]) {

  def token = config.sonarQubeTokenName ?: error("SonarQube token name is required")
  def key = config.sonarQubeProjectKey ?: error("SonarQube project key is required")
  def name = config.sonarQubeProjectName ?: error("SonarQube project name is required")
  def installation = config.sonarQubeInstallationName ?: error("SonarQube installation name is required")
  def scannerHome = config.sonarQubeScannerHome ?: tool('sonar-scanner')

  echo "SonarQube analysis started"

  withSonarQubeEnv(credentialsId: token, installationName: installation) {
    sh """
      ${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=${key} \
        -Dsonar.projectName=${name}
    """
  }

  echo " SonarQube analysis completed"
}
