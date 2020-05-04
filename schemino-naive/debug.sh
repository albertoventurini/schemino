#!/bin/bash

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 \
  -jar ./schemino-naive/target/schemino-naive-0.1.0-SNAPSHOT.jar "$@"
