FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/snackbar-server-0.0.1-SNAPSHOT.jar snackbar-server.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /snackbar-server.jar" ]