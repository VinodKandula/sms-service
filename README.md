## Synopsis

SMS Service that will proxy requests to and from a SMS provider such as Twilio

## Send a Request
curl -X GET "http://localhost:8080/smsRequests" -H "accept: application/json"

{
  "phoneNumber": "+12015551234",
  "body": "Please response Yes or No.",
  "requestNumber": 0,
  "callbackUrl": "http://example.com"
}

## Motivation

To create a generic microservice that multiple applications can use to easily send a SMS message or receive a SMS message.

## Installation
* Configure Twilio endpoint to http://hostname/smsResponses

## API Reference
* Swagger documentation: 
http://localhost:8080/swagger-ui.html

## Tests

Describe and show how to run the tests with code examples.
