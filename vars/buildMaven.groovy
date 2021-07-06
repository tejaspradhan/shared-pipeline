#!/usr/bin/env groovy

def call()
{
  bat label: '', script: 'mvn package'
}
