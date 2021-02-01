cd ..

mvn clean install
docker build -t daytrader8-derby-ejb .


docker run -p 9080:9080 -p 9443:9443 -e RUNTIME_MODE=0 -e ORDER_PROCESSING_MODE=0 daytrader8-derby-ejb
