ARG JAVA_VARIANT=eclipse-temurin
ARG JAVA_VERSION=19
FROM maven:3.9.0-${JAVA_VARIANT}-${JAVA_VERSION} AS build
WORKDIR /usr/src/app
COPY pom.xml .
COPY src/ src/
RUN mvn clean install

FROM ${JAVA_VARIANT}:${JAVA_VERSION} AS runtime
ARG JAR_FILE=target/pdfinvoices-1.0-SNAPSHOT.jar
COPY --from=build /usr/src/app/${JAR_FILE} ${JAR_FILE}
ENV JAR_FILE=${JAR_FILE}
CMD ["sh", "-c", "java -jar ${JAR_FILE}"]
