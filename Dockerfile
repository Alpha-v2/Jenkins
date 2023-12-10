FROM tomcat:latest
//COPY ./workspace/Master/target/build.war /usr/local/tomcat/webapps
RUN /usr/local/tomcat/bin/catalina.sh start
