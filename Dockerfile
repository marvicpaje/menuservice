FROM anapsix/alpine-java:latest 
COPY target/menu-0.0.1-SNAPSHOT.jar app.jar 
EXPOSE 9741 
ENTRYPOINT java -jar ./app.jar