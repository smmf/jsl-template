def call(buildOverride = null, testOverride = null) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
		    script {
			buildOverride != null ? buildOverride() : defaultBuild()
                    }
                }
            }
            stage('Test') {
                steps {
	             script {
			testOverride != null ? testOverride() : defaultTest()
                     }
                }
            }
            stage('Deploy') {
                steps {
                    echo 'Deploying...'
                }
            }
        }
    }
}

