#!/usr/bin/env groovy

def call(tokensq, boolean bool_1, boolean abortPipeline) {
    def scannerHome = tool 'SonarScanner';
    def PROJECT_NAME = "practica_1_2023_JUAN_CALDERON";
    def SONAR_AUTH_TOKEN = tokensq;
    def SONAR_HOST_URL = 'http://localhost:9000';
    
    echo "tokensq : ${tokensq}."
    echo "SONAR_AUTH_TOKEN : ${SONAR_AUTH_TOKEN}."
    echo "Booleano_1 : ${bool_1}."
    echo "Booleano_2 : ${abortPipeline}."
    
    if (abortPipeline) {
        //def ResultAbort = echo "Aborto de Pipeline - gatillado por parámetro ingresado abortPipeline"
        currentBuild.result = 'ABORTED'
        error("Aborto de Pipeline - gatillado por parámetro ingresado abortPipeline")
        //println ResultAbort
    } else {
        withSonarQubeEnv(installationName: 'sq1', credentialsId: 'SQJenkinsToken') { 
        def Result = sh (script: "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${PROJECT_NAME} -Dsonar.login=${tokensq}", returnStdout: true)
        println Result
        }
        timeout(time: 5, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: bool_1
        }
    }    
}
