# Postgres container 

### Run Postgres locally with shared volume
```
docker run --name learn_postgres -e POSTGRES_PASSWORD=docker_user -e POSTGRES_USER=docker_user -p 5433:5432 -v pgdata:/var/lib/postgresql/data -d postgres
```

### Connects to the Postgres to create the database

# Building the application

```
clear;mvn clean install -Dspring.profiles.active=local
mvn spring-boot:run -Dspring.profiles.active=local
```