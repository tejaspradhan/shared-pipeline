#!/usr/bin/env groovy

def call(url)
{
  def remote = []

  vmData = [ 1 : ["virtual_machine_1", "5c832d8a-57a6-405f-a1be-7eb0b12d517d", "192.168.50.50"], 2 : ["virtual_machine_2", "Jenkins_2", "192.168.51.51"], 3 : ["virtual_machine_3", "VirtualMachine3", "192.168.52.52"]]
  
  projectData = ["https://github.com/yashbhangdia/spring-boot-maven-example-helloworld.git" : [1, 2], "https://github.com/yashbhangdia/SpringBoot-Application-2.git" : [3]]

//   for(int i=0;i<2;i++)
//   {
//       def temp = [:]
//       temp.name = data[i][0]
//       temp.id = data[i][1]
//       temp.host = data[i][2]
//       temp.allowAnyHosts = true
//       remote.add(temp)
//   }
  
  def list = projectData["${url}"]
  
  for(int i=0;i<list.size;i++)
  {
    def temp = [:]
    temp.name = vmData[list[i]][0]
    temp.id = vmData[list[i]][1]
    temp.host = vmData[list[i]][2]
    temp.allowAnyHosts = true
    remote.add(temp)
  }
  
  
  return remote
}
