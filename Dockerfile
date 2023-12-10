FROM tomcat:latest
COPY ./webapp.war /usr/local/tomcat/webapps
RUN /usr/local/tomcat/bin/catalina.sh start
