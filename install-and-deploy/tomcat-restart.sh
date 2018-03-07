#!/bin/bash
ansible-playbook -i hosts -K --tags "tomcat-stop,tomcat-start" deploy.yml
