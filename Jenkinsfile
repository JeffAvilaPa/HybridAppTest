pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'  // ajusta si es diferente en tu Jenkins
    }

    tools {
        maven 'Maven 3.8.6'  // asegúrate que Maven esté configurado con ese nombre en Jenkins
        jdk 'Java 17'        // o el nombre que hayas definido en "Global Tool Configuration"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/TU_USUARIO/TU_REPO.git'  // cambia por tu repo
            }
        }

        stage('Instalar dependencias') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Appium Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
