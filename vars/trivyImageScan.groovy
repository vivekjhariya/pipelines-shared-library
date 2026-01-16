def call(){

   echo "Scanning Docker image..."

  sh """

  set -e
   TIMESTAMP=\$(date +%Y%m%d-%H%M%S)
   SAFE_TAG=\${IMAGE_TAG//[:\\/]_}
   REPORT_NAME=trivy-image-report-\${SAFE_TAG}-\${TIMESTAMP}.txt
   trivy image --format table \$IMAGE_TAG > \$REPORT_NAME

   echo "report genertaed: \$REPORT_NAME"
  """
     echo "Docker image scanned successfully"
  
}
