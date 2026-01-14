def call(String url, String branch){
    echo "Cloning repository ${url} at branch ${branch}"
    git url:"${url}", branch:"${branch}"

}