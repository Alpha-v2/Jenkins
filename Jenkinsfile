pipeline {

	agent none

	stages {

        stage (" checking out git repo "){

			steps {
                node{

				git branch: 'master', url: 'https://github.com/Alpha-v2/Jenkins.git'

                }
			}

				}


		stage (" Build the package"){

			steps {

                node('build_server'){
                
				sh " mvn clean install"
                }
			}
		}

		stage (" Run Docker container"){

			steps {

                node('build_server'){
                sh " docker stop sample "
				sh " docker rm sample "
				sh " docker build . -t custom"
				sh " docker run --name sample -dit -p 8181:8080 custom "
				sh " docker cp ./target/build.war sample:/usr/local/tomcat/webapps "
                }
			}

			


		}
	}
}
