FROM openjdk:8-jre-alpine

LABEL maintainer="Simon Leigh <giveit@gmail.com>" \
    org.opencontainers.image.authors="Simon Leigh" \
    org.opencontainers.image.description="An application consisting of a RESTful service implementation and OpenTelemetry." \
    org.opencontainers.image.source="https://github.com/sleighzy/useful-project-templates/java/java-restful-service" \
    org.opencontainers.image.title="java-restful-service" \
    org.opencontainers.image.vendor="Simon Leigh"

WORKDIR /usr/share/restful-app

# https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases
ARG OTEL_AGENT_VERSION=v1.4.0

# Environment variables to configure the opentelmetry agent
ENV OTEL_JAVAAGENT_ENABLED false
ENV OTEL_TRACES_EXPORTER otlp
ENV OTEL_METRICS_EXPORTER none
ENV OTEL_EXPORTER_OTLP_ENDPOINT http://localhost:4317
ENV OTEL_EXPORTER_OTLP_METRICS_ENDPOINT http://localhost:4317
ENV OTEL_SERVICE_NAME services-test-app

# Add OpenTelemetry agent for auto-instrumentation, SDK, and exporters
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/${OTEL_AGENT_VERSION}/opentelemetry-javaagent-all.jar /opentelemetry-javaagent-all.jar

COPY target/java-restful-service-1.0-SNAPSHOT-jar-with-dependencies.jar services-test-app.jar

# The JAVA_OPTS environment variable can be used to provide additional
# system properties for the Java process.
#
# The "$0 $@" suffix is used to support appending command line arguments.
ENTRYPOINT /usr/bin/java -javaagent:/opentelemetry-javaagent-all.jar $JAVA_OPTS -jar services-test-app.jar $0 $@
