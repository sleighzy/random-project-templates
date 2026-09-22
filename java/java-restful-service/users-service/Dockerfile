FROM eclipse-temurin:25-jre-alpine

LABEL maintainer="Simon Leigh <giveit@gmail.com>" \
    org.opencontainers.image.authors="Simon Leigh" \
    org.opencontainers.image.description="A Users service application consisting of a RESTful service implementation and OpenTelemetry." \
    org.opencontainers.image.source="https://github.com/sleighzy/random-project-templates/java/java-restful-service/users-service" \
    org.opencontainers.image.title="users-service" \
    org.opencontainers.image.vendor="Simon Leigh"

WORKDIR /usr/share/users-service

# https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases
ARG OTEL_AGENT_VERSION=v2.31.1

# Environment variables to configure the opentelemetry agent
ENV OTEL_JAVAAGENT_ENABLED=false
ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_METRICS_EXPORTER=none
ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4318
ENV OTEL_EXPORTER_OTLP_METRICS_ENDPOINT=http://localhost:4317
ENV OTEL_SERVICE_NAME=users-service

# Add OpenTelemetry agent for auto-instrumentation, SDK, and exporters
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/${OTEL_AGENT_VERSION}/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

COPY target/users-service-1.0.0-SNAPSHOT.jar users-service.jar

# The JAVA_OPTS environment variable can be used to provide additional
# system properties for the Java process.
ENV JAVA_OPTS=""

# The "$0 $@" suffix is used to support appending command line arguments.
ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar", "-jar", "users-service.jar", "$0", "$@"]
