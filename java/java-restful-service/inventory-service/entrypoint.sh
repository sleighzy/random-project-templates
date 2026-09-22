#!/bin/bash

java -javaagent:./opentelemetry-javaagent.jar \
    -Dotel.javaagent.enabled=false \
    -Dotel.traces.exporter=otlp \
    -Dotel.metrics.exporter=none \
    -Dotel.exporter.otlp.endpoint=http://localhost:4318 \
    -Dotel.resource.attributes=service.name=inventory-service \
    -Dotel.instrumentation.servlet-service.enabled=true \
    -jar target/inventory-service-1.0-SNAPSHOT.jar
