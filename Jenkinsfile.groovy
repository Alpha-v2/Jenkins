Pipeline {

	agent
	triggers {
        pollSCM('') //Empty quotes tells it to build on a push
    }

	Stages{

		Stage(" git repo "){

			Steps{

				git branch: 'master', url: 'https://github.com/Alpha-v2/Jenkins.git'
			}

			

				}

		Stage(" Build the package"){

			Steps{

				sh " mvn clean install"
			}
		}

		Stage(" Run Docker container"){

			Steps{

				sh " docker build --tag custom"
				sh " docker run -dit -p 82:8080 custom Apache "
			}
		}	


		}





	}