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

				sh " docker build --tag custom"
				sh " docker run -dit -p 82:8080 custom Apache "
			}
		}	


		}


