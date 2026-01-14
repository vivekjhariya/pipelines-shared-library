def call(){

sh ''' 
                set -e
                 if java -version 2>/dev/null | grep -q "openjdk"; then
                     echo "java is already installed"
                 else 
                    echo "java not found installing..."
                    sudo apt update -y
                    sudo apt install -y fontconfig openjdk-21-jre
                    java -version
                    sudo reboot
                 fi   
                 
             '''

}