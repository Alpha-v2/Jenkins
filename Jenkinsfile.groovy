pipeline {

	agent {label 'build_server'}
	

	stages {

		stage (" git repo "){

			steps {

				git branch: 'master', url: 'https://github.com/Alpha-v2/Jenkins.git'
			}

			

				}

		stage (" Build the package"){

			steps {
                
				sh " mvn clean install"
			}
		}

		stage (" Run Docker container"){

			steps {
                                sh " docker stop sample "
				sh " docker rm sample "
				sh " docker build . -t custom"
				sh " docker run --name sample -dit -p 8181:8080 custom "
				sh " docker cp ./target/build.war sample:/usr/local/tomcat/webapps "
			}

			


		}
	}
}
