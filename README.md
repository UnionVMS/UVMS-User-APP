# UVMS-User-APP

To build and deploy the project use the two steps:

mvn clean install -U -Pgenerate-from-wsdl,generate-rest-doc -Dhostname=cygnus-dev.athens.intrasoft-intl.private -Dport=28080

mvn clean install wildfly:deploy --projects module -Pwildfly-deploy -Dhostname=cygnus-dev.athens.intrasoft-intl.private -Dport=9990 -Dusername=wildfly -Dpassword=wildfly123