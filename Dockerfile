WORKDIR /app/$MSVC_NAME
COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .
RUN chmod +x mvnw
SHELL ["/bin/bash", "-c"]
#RUN ./mvnw --version
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#COPY src src
COPY ./src ./src
RUN ./mvnw clean package -DskipTests

#crear imagen
FROM openjdk:17
ARG MSVC_NAME
VOLUME /tmp

ARG TARGET_FOLDER=/app/$MSVC_NAME/target
COPY --from=builder $TARGET_FOLDER/soap.jar .

ARG APP_PORT=8087
ENV PORT $APP_PORT
EXPOSE $PORT
#EXPOSE 8083

# "-XX:+UseG0.5GC", "-Xms1G", "-Xmx1G",
CMD ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/tmp/heapdump.hprof", "clienteService.jar"]
