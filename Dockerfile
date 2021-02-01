FROM websphere-liberty

COPY server.xml /config/server.xml

#Handle exit code 22 - the feature already exists.
RUN installUtility install --acceptLicense defaultServer; if [ $? -eq 0 -o $? -eq 22 ]; then exit 0; else exit $?; fi

COPY jvm.options /config/jvm.options

COPY resources/data /opt/ibm/wlp/usr/shared/resources/data
COPY resources/DerbyLibs /opt/ibm/wlp/usr/shared/resources/DerbyLibs

USER root
RUN cd /opt/ibm/wlp/usr/shared/resources && chown -R default data
USER 1001

COPY target/daytrader8-1.0-SNAPSHOT.war /config/apps

#DERBY
#RUN mkdir -p /opt/ibm/wlp/usr/shared/resources/DerbyLibs && wget -t 10 -x -nd -P /opt/ibm/wlp/usr/shared/resources/DerbyLibs http://www-eu.apache.org/dist//db/derby/db-derby-10.14.1.0/db-derby-10.14.1.0-lib.zip && cd /opt/ibm/wlp/usr/shared/resources/DerbyLibs && unzip db-derby-10.14.1.0-lib.zip && rm db-derby-10.14.1.0-lib.zip 

#RUN apt-get update && apt-get install -y curl
#RUN /opt/ibm/wlp/bin/server start defaultServer && sleep 3 &&  curl http://localhost:9080/daytrader/config?action=buildDBTables && sleep 3 && curl localhost:9080/daytrader/config?action=buildDB && sleep 5 && /opt/ibm/wlp/bin/server stop defaultServer


