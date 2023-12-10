FROM tomcat:latest
COPY /home/ubuntu/Jenkins/workspace/Master/target /usr/local/tomcat/webapps
RUN /usr/local/tomcat/bin/catalina.sh start
