def call(){

echo "checking trivy installation"
  sh '''

  set +e

  # check if already installed

  if command -v trivy > /dev/null 2>&1; then
  echo "trivy already installed"
  trivy --version
  exit 0
  fi 
  echo "trivy not found installing......"

  set -e
sudo apt-get update -y
sudo apt-get install -y wget gnupg lsb-release

if [ ! -f /usr/share/keyrings/trivy.gpg ]; then
wget -qO - https://aquasecurity.github.io/trivy-repo/deb/public.key \
 | sudo gpg --dearmor \
 | sudo tee /usr/share/keyrings/trivy.gpg > /dev/null
 fi 
 # add trivy repo if only present
 if [! -f /etc/apt/sources.list.d/trivy.list ]; then
echo "deb [signed-by=/usr/share/keyrings/trivy.gpg] https://aquasecurity.github.io/trivy-repo/deb generic main" \
| sudo tee /etc/apt/sources.list.d/trivy.list
fi 


sudo apt-get update
sudo apt-get install -y trivy
trivy --version
 '''
  
}
