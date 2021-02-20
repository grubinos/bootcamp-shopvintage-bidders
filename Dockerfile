
FROM openjdk:11-jre
LABEL maintainer="BCP-BOOTCAMP"
COPY build/libs/bootcamp-shopvintage-bidders-*SNAPSHOT.jar /opt/bootcamp-shopvintage-bidders.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/bootcamp-shopvintage-bidders.jar"]


## MULTI-STAGE
## Compilar, ejecutar test y Crear artefacto JAR
#FROM openjdk:11 AS BUILD_IMAGE
#ENV APP_HOME=/root/dev/app/
#RUN mkdir -p $APP_HOME/src/main/java
#WORKDIR $APP_HOME
#COPY build.gradle gradlew gradlew.bat $APP_HOME
#COPY gradle $APP_HOME/gradle
#COPY . .
#RUN ls -lha
#RUN ./gradlew --stacktrace clean test build
#
## Ejecutar la aplicación
#FROM openjdk:11-jre
#LABEL maintainer="BCP-BOOTCAMP"
#WORKDIR /root/
#COPY --from=BUILD_IMAGE /root/dev/app/build/libs/bootcamp-shopvintage-bidders-*SNAPSHOT.jar /opt/bootcamp-shopvintage-bidders.jar
#ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/bootcamp-shopvintage-bidders.jar"]

