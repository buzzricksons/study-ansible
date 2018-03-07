#!/bin/bash
ansible-playbook -i hosts -K --tags "tomcat-stop" deploy.yml
