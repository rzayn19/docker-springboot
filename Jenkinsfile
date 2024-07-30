pipeline {
    agent any

    environment {
        // Define environment variables for ACR
        ACR_NAME = 'rdacr'
        ACR_REPO = 'rdacr.azurecr.io/rzayn19'
        IMAGE_NAME = 'springboot'
        SONAR_TOKEN = credentials('sonarqube-token')
        AZURE_CRED_ID = 'test-creds'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git
                git branch: 'main', url: 'https://github.com/rzayn19/docker-springboot.git'
            }
        }

        stage("build & SonarQube analysis") {
            
            steps {
              withSonarQubeEnv('Sonarqube') {
                sh 'mvn clean package sonar:sonar -Dsonar.login=$SONAR_TOKEN'
              }
            }
          } 

        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
       
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    sh "docker build -t ${ACR_REPO}/${IMAGE_NAME}:latest ."
                }
            }
        }


        stage('Login to ACR') {
            steps {
                withCredentials([azureServicePrincipal(credentialsId: "${AZURE_CRED_ID}")]) {
                    script {
                        // Login to Azure
                        sh '''
                            az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET --tenant $AZURE_TENANT_ID
                        '''
                        
                        // Login to ACR
                        sh '''
                            az acr login --name $ACR_NAME
                        '''
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Push Docker image to ACR
                sh "docker push ${ACR_REPO}/${IMAGE_NAME}:latest"
            }
        }

    }

        post {
        success {
            // Trigger CD pipeline
            build job: 'docker-springboot-CD', wait: false
        }
    }
}