#!/usr/bin/bash

mvn -Dserver.port=10071 spring-boot:run&
mvn -Dserver.port=10072 spring-boot:run&
mvn -Dserver.port=10073 spring-boot:run&
