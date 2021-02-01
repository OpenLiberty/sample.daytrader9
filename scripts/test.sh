#!/bin/bash
export JMETER_HOME=/opt/apache-jmeter-4.0

echo "test daytrader8-derby-ejb ------- EJB3 Mode -------- ------- Sync ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=0 -e ORDER_PROCESSING_MODE=0 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- EJB3 Mode -------- ------- Async ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=0 -e ORDER_PROCESSING_MODE=1 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- EJB3 Mode -------- ------- Async_2Phase ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=0 -e ORDER_PROCESSING_MODE=2 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- JDBC Mode -------- ------- Sync ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=1 -e ORDER_PROCESSING_MODE=0 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- JDBC Mode -------- -------Async ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=1 -e ORDER_PROCESSING_MODE=1 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- JDBC Mode -------- ------- Async_2Phase ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=1 -e ORDER_PROCESSING_MODE=2 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- Session to JDBC Mode -------- ------- Sync ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=2 -e ORDER_PROCESSING_MODE=0 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- Session 2 JDBC  Mode -------- -------Async ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=2 -e ORDER_PROCESSING_MODE=1 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash

echo "test daytrader8-derby-ejb ------- Session 2 JDBC Mode -------- ------- Async_2Phase ---------"
hash=`docker run -d -p 9080:9080 -e RUNTIME_MODE=2 -e ORDER_PROCESSING_MODE=2 daytrader8-derby-ejb`
sleep 60

$JMETER_HOME/bin/jmeter -n -t ../jmeter_files/daytrader8.jmx -JHOST=localhost -JPORT=9080 -JPROTOCOL=http -JDURATION=60 -JTHREADS=5
docker logs $hash
docker stop $hash
