#!/bin/bash

java -javaagent:./opentelemetry-javaagent.jar \
    -Dotel.javaagent.enabled=true \
    -Dotel.traces.exporter=otlp \
    -Dotel.metrics.exporter=none \
    -Dotel.exporter.otlp.endpoint=http://localhost:4318 \
    -Dotel.resource.attributes=service.name=orders-service \
    -Dotel.instrumentation.servlet-service.enabled=true \
    -Dotel.instrumentation.grizzly.enabled=true \
    -jar target/orders-service-1.0-SNAPSHOT-jar-with-dependencies.jar
