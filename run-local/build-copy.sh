#!/usr/bin/env bash

cd ..

./gradlew clean bootJar

cd run-local

mv ../build/libs/happy-solver-agent.jar happy-solver-agent.jar 

