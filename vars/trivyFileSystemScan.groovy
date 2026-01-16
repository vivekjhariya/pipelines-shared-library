def call(){
  echo "Scanning file system..."

  sh """
  set -e
  TIMESTAMP=\$(date +%Y%m%d-%H%M%S)
  FS_REPORT=trivy-fs-report-$\TIMESTAMP.txt
  trivy fs . > \$FS_REPORT
  echo "report generated \$FS_REPORT"

  """
}
