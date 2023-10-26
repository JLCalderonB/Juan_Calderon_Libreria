@sonarAnalysis

def call() {
  def scannerHome = tool 'SonarScanner';
  def PROJECT_NAME = "practica_1_2023_JUAN_CALDERON";
  println params
  withSonarQubeEnv(installationName: 'sq1', credentialsId: 'SQJenkinsToken') { 
    def Result = sh (script: "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${PROJECT_NAME} ", returnStdout: true)
    println Result
  
  }
  sleep(10)
  timeout(time: 5, unit: 'MINUTES') {
    waitForQualityGate abortPipeline: true
  }
}
