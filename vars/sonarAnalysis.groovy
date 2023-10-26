#!/usr/bin/env groovy

def call(boolean bool_1, boolean bool_2) {
    def scannerHome = tool 'SonarScanner';
    def PROJECT_NAME = "practica_1_2023_JUAN_CALDERON";
    def SONAR_AUTH_TOKEN = 'SQJenkinsToken';
    def Result1 = sh 'echo "ejecuciooooooooooooooooooon"'
    echo "Booleano_1 : ${bool_1}."
    echo "Booleano_2 : ${bool_2}."
    println Result1
    def Result2 = sh (script: "${scannerHome}/bin/sonar-scanner -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.projectKey=${PROJECT_NAME} ", returnStdout: true)
    println Result2
  
}
