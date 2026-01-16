call def (String owaspdepsName){
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: '${owaspdepsName}'
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
