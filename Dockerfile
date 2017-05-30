FROM tomcat
ENV DEPLOY_DIR ${CATALINA_HOME}/webapps
COPY target/docker-java-postgres-1.0 ${DEPLOY_DIR}/docker-java-postgres-1.0
