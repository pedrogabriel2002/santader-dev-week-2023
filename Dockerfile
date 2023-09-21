FROM openjdk:17
ADD ./santanderdw-spring-boot.jar santanderdw-spring-boot.jar
ENTRYPOINT [ "java", "-jar", "santanderdw-spring-boot.jar" ]