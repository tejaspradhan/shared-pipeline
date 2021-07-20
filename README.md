# Jenkins CI/CD Shared Library for VHS Deployment
> A custom made library for CI/CD in Jenkins and Deployment on Virtual Machines.
<!-- > Live demo [_here_](https://www.example.com). If you have the project hosted somewhere, include the link here. -->

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Contact](#contact)
<!-- * [License](#license) -->


## General Information
- Shared Library made for easy CI/CD Implementation through jenkins pipelines
- Using this, Developers don't have to worry about Deployment process and also makes tasks easier for Dev-Ops
- Specially made for VHS technology and deployments on Virtual Machines
- Easy to setup and use
- Also has methods for database automation using liquibase
<!-- You don't have to answer all the questions - just the ones relevant to your project. -->


## Technologies Used
- Groovy Scripts - For Pipeline
- Shell Scripts - For ssh actions
- Maven
- Liquibase


## Features
List the ready features here:
- Can do complete CI/CD by just passing url of the project
- Can also be used to implement subtasks individually in CI/CD implementations
- Also works with custom dashboard, which is also available on Github
- Easy  for tweaks,updates and changes 


## Screenshots
![CI/CD Jenkins Screenshot](./img/screenshot.png)
<!-- If you have screenshots you'd like to share, include them here. -->


## Setup
Requirements on Server-
Java 8 or above
Maven
Liquibase
Github account and credentials
Database configurations (If required in project)
SSH configurations (For connecting to virtual machines)



## Usage
For Complete CI/CD - 
Include Library in Custom pipeline by -
`@Library('common') _`

Set URL to your Github project by - 
`def url = " "`
Include your url inside " "

For using methods in already achieved CI/CD - 
Call function in stage
`functionname(url)`



## Project Status
Project is: _in progress_ 



## Contact
Created by [Shriram](https://github.com/Shrirampareek888) [Tejas](https://github.com/tejaspradhan) and [Yash](https://github.com/yashbhangdia)- feel free to contact me!


<!-- Optional -->
<!-- ## License -->
<!-- This project is open source and available under the [... License](). -->

<!-- You don't have to include all sections - just the one's relevant to your project -->
