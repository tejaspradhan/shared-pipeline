#!/usr/bin/env groovy

def call(url)
{
  git changelog: false, credentialsId: 'GIT_HUB_CREDENTIALS', poll: false, url: "${url}"
}
