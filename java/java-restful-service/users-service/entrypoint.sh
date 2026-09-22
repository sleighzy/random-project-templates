#!/bin/bash

java -javaagent:./opentelemetry-javaagent.jar \
    -Dotel.javaagent.enabled=false \
    -Dotel.traces.exporter=otlp \
    -Dotel.metrics.exporter=none \
    -Dotel.exporter.otlp.endpoint=http://localhost:4318 \
    -Dotel.resource.attributes=service.name=users-service \
    -Dotel.instrumentation.servlet-service.enabled=true \
    -jar target/users-service-1.0.0-SNAPSHOT.jar
