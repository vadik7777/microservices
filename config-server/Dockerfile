FROM maven:3.8.4-openjdk-11-slim AS build
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
ADD ./pom.xml $PROJECT_DIR
RUN mvn dependency:resolve
ADD ./src/ $PROJECT_DIR/src
RUN mvn install

FROM openjdk:11-jre-slim
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=build $PROJECT_DIR/target/configserver.jar $PROJECT_DIR/
EXPOSE 5000
CMD ["java", "-jar", "/opt/project/configserver.jar"]