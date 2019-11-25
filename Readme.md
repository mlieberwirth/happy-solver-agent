# Happy-Solver-Agent

Runs optimizations of the [Happy-Solver](https://github.com/mlieberwirth/happy-solver). Is registered by the HappySolver-Server and can have replications to run more algos parallel.
Current integrated optimizations:
 - BinPacking 

## Preconditions
You need Java 8 and gradle.

## Run Agent

### Run in IDE

You only need to compile the sources as gradle-project in for instance eclipse and run AgentLauncher.java as application. Relevant application.yml is under 'src/main/resources'

### Run with gradle

    ./gradlew bootRun

### Create and run jar 
For build a jar use gradle

    ./gradlew bootJar
    
after that a executable jar is under /build/libs/. Run it with
    
    java -jar ./build/libs/happy-solver-agent.jar

### With bash

Execute ``./build-copy.sh && ./run.sh`` in folder run-local. Relevant application.yml is in same folder.

## RESTful Web Service endpoints

The REST-Api is documented by swagger2. If the server is running on localhost with port 8300 it is available under

    http://localhost:8300/swagger-ui.html

## CI
See [Travis CI](https://travis-ci.org/mlieberwirth/happy-solver-agent?utm_medium=notification&utm_source=github_status)

# TODO

- add happy-solver-jar

## Test
- Write MVC-Tests
- Write JUnit tests

## Others
- Errorhandling
- Model-Size limit

