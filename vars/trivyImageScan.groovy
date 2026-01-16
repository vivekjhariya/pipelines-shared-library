def call() {

  echo "Scanning Docker image..."

  sh """
    set -e

    TIMESTAMP=\$(date '+%Y%m%d-%H%M%S')

    SAFE_TAG=\$(echo "\$IMAGE_TAG" | sed 's#[/:]#_#g')
    REPORT_NAME=trivy-image-report-\${SAFE_TAG}-\${TIMESTAMP}.txt

    trivy image --format table "\$IMAGE_TAG" > "\$REPORT_NAME"
    echo "report generated: \$REPORT_NAME"
  """

  echo "Docker image scanned successfully"
}
