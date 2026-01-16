def call(String imageName){

   echo "Scanning Docker image..."

  sh '''

  set -e
   TIMESTAMP=\$(date+ "%Y%m%d-%H%M%S")
   REPORT_NAME="trivy-image-report-${imageName}-\${TIMESTAMP}.txt"
   trivy image --format table ${imageName} > \$REPORT_NAME

   echo "report genertaed: \$REPORT_NAME"
  '''
     echo "Docker image scanned successfully"
  
}
