#!/usr/bin/env groovy

def call(args)
{
  sh 'echo "Hello ${args}! this is test from shared pipeline code"'
}
