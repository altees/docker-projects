#!/bin/bash
echo "HEllo dosto"
echo $PWD
cd $PWD/"Discovery-service"
service="Discovery-service"
mvn clean install
echo "Discovery-service build success"
sleep 2s
cd $PWD/"edge-service"
mvn clean install
echo "edge-service build success"