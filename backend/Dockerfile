FROM openjdk:17-alpine

WORKDIR /app

COPY ./build .

WORKDIR /app/libs

CMD [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app-0.0.1-SNAPSHOT.jar" ]

EXPOSE 8000
EXPOSE 5005