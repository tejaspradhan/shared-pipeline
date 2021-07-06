#!/usr/bin/env groovy

def call(url)
{
  def remote = []

  def vmData = data.vm()
  def projectData = data.project()
  
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
