#!/bin/bash
#下記の作業を順番で行います。
#1.git pull
#2.Maven build
#3.Tomcat Stop
#4.Copy Deploy War Files to Tomcat webapps
#5.Tomcat-Start
#6.Check Tomcat

ansible-playbook -i hosts -K deploy.yml
