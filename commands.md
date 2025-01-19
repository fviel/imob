# Postgres container 

### Run Postgres locally with shared volume
```
docker run --name pgimob -e POSTGRES_PASSWORD=imob_pwd -e POSTGRES_USER=sa_imob -p 5440:5432 -v pgdata:/var/lib/postgresql/data -d postgres:17-alpine
```

### Configure Postgres
```
docker exec -it pgimob bash
su -postgres
CREATE ROLE sa_imob with login SUPERUSER PASSWORD ‘imob_pwd’;
ALTER USER sa_imob WITH CREATEDB CREATEROLE;
```


# Building the application

```
clear;mvn clean install -U -Dspring.profiles.active=local
mvn spring-boot:run -Dspring.profiles.active=local
```