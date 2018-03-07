#!/bin/bash
#下記の作業を順番で行います。
#1.start tomcat
#2.start apache

ansible-playbook -i hosts -K start.yml
