#!usr/bin/env groovy

def call(url)
{
  def remote = getVM("${url}")
  
  remote.each{
        item -> L:{
            echo "Deploying to : ${item.name}"

            withCredentials([sshUserPrivateKey(credentialsId: item.id, keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: item.name)]) {
          item.user = item.name
          item.identityFile = identity
          sshCommand remote: item, command: 'rm -R deployment', failOnError:'false'
          sshCommand remote: item, command: 'mkdir deployment', failOnError:false
          sshCommand remote : item, command: 'cd /home/'+"${item.name}"+'/deployment; PID=`ps -eaf | grep "java -jar" | grep -v grep | awk \'{print $2}\'`; if [[ "" !=  "$PID" ]]; then echo "found $PID and killing it!!" ; kill -9 $PID; fi'
          sshPut remote: item, from: "./target", filterRegex: /.jar$/, into: '/home/'+"${item.name}"+'/deployment/'
          sshCommand remote: item, command: 'cd /home/'+"${item.name}"+'/deployment/target; nohup java -jar *.jar >> app.log &'
            }
        }
    }
  
}
