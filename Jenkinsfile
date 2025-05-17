pipeline {
    agent any

    environment {
        JAVA_HOME = '/Library/Java/JavaVirtualMachines/amazon-corretto-17.jdk/Contents/Home'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    tools {
        maven 'Maven3' // Asegúrate de que en Jenkins esté configurado un Maven con este nombre
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10')) // Guarda solo los últimos 10 builds
        timestamps() // Agrega timestamps a la consola
    }

    triggers {
        pollSCM('* * * * *') // (opcional) chequea cambios cada minuto
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        failure {
            echo '❌ Algo salió mal con los tests.'
        }
        success {
            echo '✅ Todo funcionó correctamente.'
        }
    }
}
