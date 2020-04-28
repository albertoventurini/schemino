#!/bin/bash

java -Dtruffle.class.path.append=./target/schemino-truffle-0.1.0-SNAPSHOT.jar \
  -jar ./target/schemino-truffle-0.1.0-SNAPSHOT.jar "$@"
