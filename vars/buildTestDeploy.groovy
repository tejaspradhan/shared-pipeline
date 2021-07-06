#!usr/bin/env groovy

def call(url)
{
  node()
  {
      stage("Git Clone")
      {
          gitClone("${url}")
      }

      stage("Build Maven")
      {
          buildMaven()
      }

      stage("Deployment")
      {
          deploy("${url}")
      }

      stage("Post Deployment")
      {
          postDeploy("${url}")
      }

      stage("Dashboard")
      {
          echo "For Dashboard : http://127.0.0.1:5000/"
      }
  }
}
