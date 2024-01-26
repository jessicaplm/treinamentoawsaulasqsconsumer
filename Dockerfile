FROM openjdk:11
MAINTAINER github/jessicaplm
ADD target/treinamentoawsaulasqsconsumer-0.0.1-SNAPSHOT.jar treinamentoawsaulasqsconsumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "treinamentoawsaulasqsconsumer-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090
