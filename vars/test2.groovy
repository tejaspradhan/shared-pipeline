#!/usr/bin/env groovy

def call()
{
  def remote = []

  data = [["virtual_machine_1", "5c832d8a-57a6-405f-a1be-7eb0b12d517d", "192.168.50.50"], ["virtual_machine_2", "Jenkins_2", "192.168.51.51"]]

  for(int i=0;i<2;i++)
  {
      def temp = [:]
      temp.name = data[i][0]
      temp.id = data[i][1]
      temp.host = data[i][2]
      temp.allowAnyHosts = true
      remote.add(temp)
  }
  
  return remote
}
