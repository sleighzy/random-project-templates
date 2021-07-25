# Java RESTful Service

An example Java application consisting of two services.

## Building and Running

Run the below command to compile, run the tests, and build the Docker image.

```sh
mvn clean package
```

The application can be run from the commandline as a standalone process using
the provided script.

```sh
./entrypoint.sh
```

The application can be run as a Docker container using the provided Docker
Compose file.

```sh
docker-compose up -d
```

## Making Service Calls

The REST service can be invoked using cURL, or the fantastic [HTTPie] as shown
in the examples below.

To retrieve the details of an order:

```bash
$ http :8080/inventory/1

HTTP/1.1 200 OK
Content-Length: 10
Content-Type: application/json

{
    "id": "1"
}
```

POST the contents of the `order.json` file to the Orders service to create an
order. The Orders service will call the Inventory service as part of this
process.

```bash
$ http POST :8080/orders < order.json

HTTP/1.1 200 OK
Content-Length: 111
Content-Type: application/json

{
    "createdAt": "2021-07-29",
    "id": "1",
    "productId": "1",
    "status": "Submitted",
    "updatedAt": "2021-07-29",
    "userId": null
}
```

## Integration with OpenTelemetry

The Docker Compose file contains services for the OpenTelemetry Collector and
Jaeger to collect and visualise the traces produced by the service calls. The
`docker-compose.yaml` file needs to be updated to set the
`OTEL_JAVAAGENT_ENABLED` environment variable to `true` so that the Java agent
to send traces to the collector is started. The below command will run the
application and start the additional services.

```sh
docker-compose up -d --profile opentelemetry
```

Navigate to <http://localhost:16686/search> in your browser to view traces in
Jaeger.

[httpie]: https://httpie.io/
