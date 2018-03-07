#!/bin/bash
ansible-playbook -i hosts -K --tags "oracle-jdk8,apache,tomcat" install.yml
