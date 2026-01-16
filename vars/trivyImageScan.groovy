def call(String imageName){

   echo "Scanning Docker image..."

  sh '''
   trivy image --format table ${imageName} > trivy-image-report.txt
  '''
     echo "Docker image scanned successfully"
  
}
