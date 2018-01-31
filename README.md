## Synopsis

SMS Service that will proxy requests to and from a SMS provider such as Twilio.

1. An application will posta request to the SMS service endpoint /smsRequests.  The Sms service will save the request and send it to Twilio.
2. Twilio will then send a SMS message to the phone.
3. The phone user can then send a SMS response back, which Twilio will forward to the SMS-service's endpoint /smsResponses
4. The SMS service will match the request with the latest SMS request by phone number, save the request, and then POST the SMS object back to the callback URL.

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
1. Configure Twilio endpoint to http://hostname/smsResponses
2. For local deployment, you will need to setup the following environment variables:
  * vcap_services_twilio_credentials_account_sid=AAAAAA
  * vcap_services_twilio_credentials_auth_token=BBBBB
  * vcap_services_twilio_credentials_phone_number=+12015551234
3. Start service
  * mvn clean install
  * mvn spring-boot:run

## API Reference
* Swagger documentation: 
http://localhost:8080/swagger-ui.html

## Tests

Tests can be started with maven.
