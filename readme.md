# Pendências:

1. application.yaml não está aceitando variáveis, conforme o exemplo abaixo:
 spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    show-sql: true
    properties:
      hibernate:
        format_sql: true
dotenv:
  enabled: true
  locations:
    - file:./.env

2. Mesmo compilando com Dspring.active.profile=dev, não sobrescreve application.yaml com application-dev.yaml

3. Mesmo definindo active profile no pom.xml, não sobrescreve application.yaml com application-dev.yaml

4. Necessitei exportar o conteúdo de .env no shell para poder acessá-lo, pois não o carregou de .env
   export DB_URL=jdbc:postgresql://localhost:5440/imob
   export DB_USERNAME=sa_imob
   export DB_PASSWORD=imob_pwd

5. Executando postgres na 5440, pois outra instância já utiliza 5432

6. Falha ao executar pgadmin