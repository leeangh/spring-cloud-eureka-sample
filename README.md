# spring-cloud-eureka-sample

## Create Eureka Server

```shell
spring init --build=maven --java-version=1.8 --dependencies=cloud-eureka-server eureka-server.zip
```

## Create Eureka Service

```shell
spring init --build=maven --java-version=1.8 --dependencies=cloud-eureka-server,cloud-eureka eureka-service.zip
```


## Start the samples

```shell
cd eureka-server
mvn -Dspring.profiles.active=1 spring-boot:run
```

```shell
cd eureka-server
mvn -Dspring.profiles.active=2 spring-boot:run
```

```shell
cd eureka-service
mvn -Dserver.port=8071 spring-boot:run
```
