#!/usr/bin/env groovy

def call(url)
{
//   echo "Hello ${args}! this is test from shared pipeline code"
//   def x = test2()
//   echo "${x}"
  
  def remote = []
  remote = getVM("${url}")
  echo remote[0].name
  
}
