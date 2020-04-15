#!/bin/bash

NATIVE_IMAGE=`which native-image`

if [ ! $NATIVE_IMAGE ]; then
  echo "The native-image command was not found. Aborting"
  exit 1
fi

mvn clean package

mkdir bin

native-image -jar schemino-naive/target/schemino-naive-0.1.0-SNAPSHOT.jar bin/schemino --no-fallback