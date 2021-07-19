#!usr/bin/env groovy

def call()
{
  bat label: '', script: 'mvn liquibase:update'
          
  withCredentials([ usernamePassword(credentialsId: 'MySQL', usernameVariable: 'username', passwordVariable: 'password')]) {
    bat label: '', script: 'mysql -u'+username+' -p'+password+' -h192.168.43.146 -e  "SELECT AUTHOR, ID, DATEEXECUTED, EXECTYPE, DEPLOYMENT_ID FROM liquibase.databasechangelog ORDER BY ORDEREXECUTED DESC LIMIT 1" > dbcheck.txt '
  }
}
