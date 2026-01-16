
def call(String owaspDepsName) {

  echo " OWASP Dependency-Check scan started..."

  dependencyCheck(
    odcInstallation: owaspDepsName,
    additionalArguments: '''
      --scan .
      --format XML
      --out dependency-check-report
      --failOnCVSS 7
    '''
  )

  dependencyCheckPublisher(
    pattern: '**/dependency-check-report/dependency-check-report.xml'
  )

  echo " OWASP Dependency-Check scan complete"
}
