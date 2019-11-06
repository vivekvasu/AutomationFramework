pipeline { 
    agent any 
    stages { 
   		 stage('Clean Directory') { 
            steps { 
            	withMaven(maven : 'MAVEN_HOME')
            	{
            		 bat 'mvn clean'
            	}
            }
        }
        stage('Compile Build') { 
            steps { 
               withMaven(maven : 'MAVEN_HOME')
            	{
            		 bat 'mvn install'
            	}
            }
        }
         stage('Deploy Build') { 
            steps { 
               withMaven(maven : 'MAVEN_HOME')
            	{
            		 bat 'mvn deploy'
            	}
            }
        }
    }
    post {
   		 failure {
        		mail to: 'vivekvivi39@gmail.com',
             	subject: "Build Failed: ${currentBuild.fullDisplayName}",
            	body: "Something is wrong with ${env.BUILD_URL} \n This is probably due to compilation issue. Kindly resolve it."
    			}
		}
		success {
        		mail to: 'vivekvivi39@gmail.com',
             	subject: "Build Success: ${currentBuild.fullDisplayName}",
            	body: "Latest build is successfully deployed to artifactory."
    			}
		}
}