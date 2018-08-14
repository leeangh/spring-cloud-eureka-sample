# spring-cloud-eureka-sample

## Create Eureka Server

```shell
spring init --build=maven --java-version=1.8 --dependencies=cloud-eureka-server eureka-server.zip
```

## Create Eureka Service

```shell
spring init --build=maven --java-version=1.8 --dependencies=cloud-eureka-server,cloud-eureka eureka-service.zip
```
