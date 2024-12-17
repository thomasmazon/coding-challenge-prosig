# Docker Compose Spring Boot and Postgres demo
## Technologies
- Spring Boot
- Postgresql
- Docker
- Docker Compose

## Run the System

### Locally 

Run the following command:
```bash
mvn clean package -DskipTests
java -jar target/coding-challenge-prosig[^source].jar
```

### Docker Command

```bash
docker build --tag=prosigliere-challenge-server:latest .
docker run -6868:8080 prosigliere-challenge-server:latest
```

### Stop Docker 
```bash
docker stop prosigliere-challenge-server
docker rm prosigliere-challenge-server
```

### Docker Compose
```bash
docker-compose up
```

## Stop the System
To stop all running containers, use this command:
```bash
docker-compose down



