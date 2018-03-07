#!/bin/bash
ansible-playbook -i hosts -K --tags "tomcat-start" deploy.yml
