def call(String dockerImageName, int keep =1){
    sh '''


echo "keeping the latest ${keep} images for ${dockerImageName} and removing older ones"
docker images ${dockerImageName} --format "{{.ID}}"
| tail -n +$((keep + 1))
| xargs -r docker rmi -f
    '''
}