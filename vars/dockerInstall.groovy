def call(){
    sh '''
     set -e 
                    if docker --version 2>/dev/null | grep -q "Docker"; then
                        echo "docker is already installed"
                    else 
                        echo "docker not found. installing.."
                        sudo apt-get update -y
                        curl -fsSL https://get.docker.com | sudo sh
                        sudo systemctl enable docker 
                        sudo systemctl start docker
                        sudo usermod -aG docker jenkins
                        sudo usermod -aG docker $USER
                        sudo systemctl restart jenkins
                        sudo -u jenkins docker --version
                        sudo systemctl status jenkins
                        sudo reboot
                    fi
                    
                    if docker compose version >/dev/null 2>&1; then
                        echo "docker-compose is already installed"
                    else
                        echo "docker compose-v2 not found. installing..."
                        sudo mkdir -p /usr/local/lib/docker/cli-plugins
                        sudo curl -SL https://github.com/docker/compose/releases/download/v2.25.0/docker-compose-linux-x86_64 \
                            -o /usr/local/lib/docker/cli-plugins/docker-compose
                        sudo chmod +x /usr/local/lib/docker/cli-plugins/docker-compose
                    fi


    '''
}