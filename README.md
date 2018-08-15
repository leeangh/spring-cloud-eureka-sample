# spring-cloud-eureka-sample

## Create Eureka Server

```bash
spring init --build=maven --java-version=1.8 --dependencies=cloud-eureka-server eureka-server.zip
```

## Create Eureka Service

```bash
spring init --build=maven --java-version=1.8 --dependencies=cloud-eureka-server,cloud-eureka eureka-service.zip
```

## Modify HOSTS
```bash
127.0.0.1       eureka-peer1 eureka-peer2 eureka-service-p1
```

## Start the samples

```bash
cd eureka-server
mvn -Dspring.profiles.active=1 spring-boot:run
```

```bash
cd eureka-server
mvn -Dspring.profiles.active=2 spring-boot:run
```

```bash
cd eureka-service
mvn -Dserver.port=8071 spring-boot:run
```
