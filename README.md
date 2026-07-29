## Buillding an image


```bash
docker build -t teja463/docker-java .
```


The image is available on docker hub **teja463/docker-java**


## Running the App

- To start the app run `docker compose -f postgres-compose.yml up -d`
- Update the props in application.properites like below
`
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=postgres
`