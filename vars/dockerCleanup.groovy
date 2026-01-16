def call(String imageName, int keepImages = 2) {

    sh '''
        set +e
        echo "Keeping latest images and removing older ones"

        docker images ''' + imageName + ''' --format '{{.ID}}' \
        | awk '!seen[$0]++' \
        | tail -n +''' + (keepImages + 1) + ''' \
        | xargs -r docker rmi -f
    '''
}





