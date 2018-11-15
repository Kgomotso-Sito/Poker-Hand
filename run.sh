#!/bin/bash
if [ -d target ]; then
    java  -jar target/assessment-0.0.1-SNAPSHOT.jar
else
    mvn clean compile assembly:single
    java -jar target/assessment-0.0.1-SNAPSHOT.jar
fi


