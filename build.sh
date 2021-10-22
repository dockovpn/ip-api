#!/usr/bin/env bash

rm -R target

sbt ';build'

docker build -t alekslitvinenk/ip-api:latest . --no-cache
docker push alekslitvinenk/ip-api:latest