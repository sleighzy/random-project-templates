#!/bin/bash

java -javaagent:./opentelemetry-javaagent-all.jar \
    -Dotel.javaagent.enabled=true \
    -Dotel.traces.exporter=otlp \
    -Dotel.metrics.exporter=none \
    -Dotel.exporter.otlp.endpoint=http://localhost:55680 \
    -Dotel.resource.attributes=service.name=restful-app \
    -Dotel.instrumentation.servlet-service.enabled=true \
    -Dotel.instrumentation.grizzly.enabled=true \
    -jar target/java-restful-service-1.0-SNAPSHOT-jar-with-dependencies.jar