pipeline {
    agent any

    tools{
        maven 'maven_3.8.6'
    }

	environment{
		LOCAL_IMAGE = 'books:latest'
		REPO_IMAGE = 'jflumbansiantar/books:latest'
	}

    stages{

		stage('Deploy'){
            steps {
				withCredentials([
            		usernamePassword(credentialsId:'docker', usernameVariable:'username', passwordVariable:'password')
            	]){
					bat 'docker login -u ${username} --password-stdin ${password}'
					bat 'mvn jib:dockerBuild'
					bat 'docker tag $LOCAL_IMAGE $REPO_IMAGE'
					bat 'docker push $REPO_IMAGE'
					bat 'docker rmi $REPO_IMAGE'
				}
            }
        }
    }
}
