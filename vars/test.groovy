#!/usr/bin/env groovy

def call(args)
{
  echo "Hello ${args}! this is test from shared pipeline code"
  String x = test2()
  echo "${x}"
}
