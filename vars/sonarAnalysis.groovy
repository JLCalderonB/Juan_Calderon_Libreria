#!/usr/bin/env groovy

def call(Boolean bool_1, Boolean bool_2) {
  
    def Result = sh 'echo "ejecuciooooooooooooooooooon"'
    echo "Booleano_1 : ${bool_1}."
    echo "Booleano_2 : ${bool_2}."
    println Result
  
}
