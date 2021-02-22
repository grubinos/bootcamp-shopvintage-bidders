FROM openjdk:11-jre
LABEL maintainer="BCP-BOOTCAMP"
COPY build/libs/bootcamp-shopvintage-bidders-*SNAPSHOT.jar /opt/bootcamp-shopvintage-bidders.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/bootcamp-adventureworks-products.jar"]