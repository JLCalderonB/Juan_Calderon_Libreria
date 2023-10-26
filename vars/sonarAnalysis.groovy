#!/usr/bin/env groovy

def call(tokensq, boolean bool_1, boolean bool_2) {
    def scannerHome = tool 'SonarScanner';
    def PROJECT_NAME = "practica_1_2023_JUAN_CALDERON";
    def SONAR_AUTH_TOKEN = tokensq;
    def SONAR_HOST_URL = 'http://localhost:9000';
    
    echo "tokensq : ${tokensq}."
    echo "SONAR_AUTH_TOKEN : ${SONAR_AUTH_TOKEN}."
    echo "Booleano_1 : ${bool_1}."
    echo "Booleano_2 : ${bool_2}."
    
    def Result2 = sh (script: "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${PROJECT_NAME} -Dsonar.login= ${tokensq} -Dsonar.host.url=${SONAR_HOST_URL}", returnStdout: true)
    println Result2
  
}
