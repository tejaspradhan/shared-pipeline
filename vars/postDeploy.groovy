#!/usr/bin/env groovy

def call(url)
{
  def remote  = getVM("${url}")
  
  bat 'IF EXIST info RMDIR /S /Q info'
  bat 'mkdir info'

  remote.each{
      item -> L:{
          withCredentials([sshUserPrivateKey(credentialsId: item.id, keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: item.name)]) {
            item.user = item.name
            item.identityFile = identity

            sshCommand remote: item, command: 'cd /home/'+"${item.name}"+'/deployment; rm -R temp', failOnError:'false'
            sshCommand remote: item, command: 'cd /home/'+"${item.name}"+'/deployment; mkdir temp; cd temp; jar xvf ../target/*.war'
            sshCommand remote: item, command: 'cd /home/'+"${item.name}"+'/deployment/temp/META-INF/maven/org.springframework.boot/SpringBootMavenExample; ls'
            sshGet remote: item, from:'deployment/temp/META-INF/maven/org.springframework.boot/SpringBootMavenExample/pom.properties', into: 'info/'+"${item.name}"+"-"+"${item.host}"+'.txt', override: true
            sshCommand remote: item, command: 'cd /home/'+"${item.name}"+'/deployment; rm -R temp', failOnError:'false'
          }
      }
  }
  
}
