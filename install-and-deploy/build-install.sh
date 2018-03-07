#!/bin/bash
ansible-playbook -i hosts -K --tags "user,oracle-jdk8,apache,tomcat" install.yml
