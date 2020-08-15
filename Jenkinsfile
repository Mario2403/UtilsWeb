pipeline {
  agent any
  triggers {
  pollSCM ''
}
  stages {
    stage('build') {
      steps {
        sh 'npm install'
      }
    }

    stage('run') {
      steps {
        sh 'npm run serve'
      }
    }

  }
}
