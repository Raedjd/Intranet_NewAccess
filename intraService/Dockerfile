FROM openjdk:8

ADD target/raedjd.war raedjd.war

EXPOSE 8080

ENTRYPOINT ["java", "-war", "raedjd.war"]