# register Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using:
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/register-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.


#### PASSOS PARA GERAR BUILDAR APP QUARKUS E MANDAR PARA KUBERNATES (GRAAL-VM COMMUNITE EDITION)

1. Gerando o artefato jar em /target
    1. Compilando para JVM:
        1. mvn clean compile package
        2. java -jar seuapp-1.0-SNAPSHOT-runner.jar
    2. Compilando para versão nativa:
        1. mvn clean compile package -Pnative
        2. java -jar seuapp-1.0-SNAPSHOT-runner
    3. Compilando artefato para linux:
        1. mvn package -Pnative -Dquarkus.native.container-build=true
        2. java -jar seuapp-1.0-SNAPSHOT-runner

2. Dockerizando aplicação:
    1. docker build -f src/main/docker/Dockerfile.native -t quarkus/seuapp .
    2. docker run -i --rm -p 8088:8088 quarkus/seuapp

3. Enviando para docker hub aplicação dockerizada:
    1. docker tag quarkus/seuapp jimmmisss/seuapp
    2. docker push jimmmisss/seuapp

4. K8s:
    1. kubectl run seuapp --image=jimmmisss/seuapp --port=8080
    2. kubectl get pods
    3. kubectl expose deployment seuapp --type=NodePort
    4. kubectl get services
