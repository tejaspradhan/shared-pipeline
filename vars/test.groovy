#!/usr/bin/env groovy

def call(args)
{
  echo "Hello ${args}! this is test from shared pipeline code"
  def x = test2()
  echo "${x}"
}
