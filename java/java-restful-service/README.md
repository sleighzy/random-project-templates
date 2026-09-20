# Java RESTful Service

An example Java application consisting of two services.

## Building and Running

Run the below command to compile, run the tests.

```sh
mvn clean package
```

The application can be run from the commandline as a standalone process using
the provided script.

```sh
./entrypoint.sh
```

The application can be run as a Docker container by building the image using the
below command.

```sh
docker build -t java-restful-service:1.0-SNAPSHOT .
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

The services in the application are instrumented with OpenTelemetry, allowing
for distributed tracing and metrics collection. To run this in a development
environment, you can use the provided Docker Compose setup.

For a quick start with OpenTelemetry using Grafana Tempo and the Grafana
observability stack, refer to the [Quick Start for Tempo] to stand up the Docker
stack. The container deployment information in this project's [Docker Compose
file] can be copied into the Docker Compose file used for the Grafana stack.

[Docker Compose file]: ./docker-compose.yaml
[Quick Start for Tempo]: https://grafana.com/docs/tempo/latest/docker-example/
[httpie]: https://httpie.io/
