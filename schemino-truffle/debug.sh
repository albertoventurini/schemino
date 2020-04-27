#!/bin/bash

java -Dtruffle.class.path.append=./target/schemino-truffle-0.1.0-SNAPSHOT.jar \
  -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 \
  -jar ./target/schemino-truffle-0.1.0-SNAPSHOT.jar
