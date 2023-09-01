FROM khipu/openjdk17-alpine
RUN addgroup -S spring && adduser -S shamstabrez542 -G spring
USER shamstabrez542:spring
VOLUME /tmp
ARG JAR_FILE=target/order-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} /app/orderservice.jar

# Set the default Spring profile to 'docker'
ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/orderservice.jar"]
