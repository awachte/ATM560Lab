Server_Client_Interface.java

Server_Object.java

Server.java

Client.java - The client side of the program.  Started from the command line with information to wh$

policy - includes security permissions.  All permission.

Makefile - make information for project

Compile and run instructions:

make
rmiregistry &
jar cvf server.jar *.class
/usr/lib/jvm/java-7-openjdk-amd64/bin/java -Djava.security.policy=policy Server &
