FROM eclipse-temurin:17-jre
VOLUME /tmp
ARG JAR_FILE=target/hello-oci-k8s-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]