#!/bin/bash

cd "$(dirname "$0")"
cd ..

echo "Build Image"
mvn clean install
docker build -t daytrader8-derby-ejb .

docker images | grep daytrader8
