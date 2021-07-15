#!usr/bin/env groovy

def call(url)
{
  def remote = getVM("${url}")
  
  def applist = data.app()
  def appname = applist["${url}"]
  
  remote.each{
        item -> L:{
            echo "Deploying to : ${item.name}"

          withCredentials([sshUserPrivateKey(credentialsId: item.id, keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: item.name)]) {
          item.user = item.name
          item.identityFile = identity
          sshCommand remote : item, command: 'cd /home/'+"${item.name}"+'/'+"${appname}"+'/target; TEMP=`find *.jar | awk \'{print $1}\'`; PID=`ps -eaf | grep "java -jar $TEMP" | grep -v grep | awk \'{print $2}\'`; if [[ "" !=  "$PID" ]]; then echo "found $PID and killing it!!" ; kill -9 $PID; fi'
          sshCommand remote: item, command: 'rm -R '+"${appname}", failOnError:'false'
          sshCommand remote: item, command: 'mkdir '+"${appname}", failOnError:false
          sshPut remote: item, from: "./target", filterRegex: /.jar$/, into: '/home/'+"${item.name}"+'/'+"${appname}"+'/'
          sshCommand remote: item, command: 'cd /home/'+"${item.name}"+'/'+"${appname}"+'/target; nohup java -jar *.jar >> app.log &'
            }
        }
    }
  
}
