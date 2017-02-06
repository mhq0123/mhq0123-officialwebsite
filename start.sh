#!/bin/bash
java -jar service-registry.jar --spring.profiles.active=prod &
java -jar config-server.jar --spring.profiles.active=prod &
java -jar microservice-customer.jar --spring.profiles.active=prod &
java -jar microservice-sms.jar --spring.profiles.active=prod &
java -jar edge-service.jar --spring.profiles.active=prod &
java -jar service-gateway.jar --spring.profiles.active=prod &
java -jar web-client.jar --spring.profiles.active=prod &