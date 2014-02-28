JFLAGS = -g
JC = /usr/lib/jvm/java-7-openjdk-amd64/bin/javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        interact/Server_Client_Interface.java \
        client/Client.java \
        server/Server_Object.java \
        server/Server.java

default: Server_Client_Interface.class Client.class Server_Object.class Server.class jar

Server_Client_Interface.class: interact/Server_Client_Interface.java
	$(JC) $(JFLAGS) interact/Server_Client_Interface.java

Client.class: client/Client.java
	$(JC) $(JFLAGS) interact/Server_Client_Interface.java client/Client.java

Server_Object.class: server/Server_Object.java
	$(JC) $(JFLAGS) interact/Server_Client_Interface.java server/Server_Object.java

Server.class: server/Server.java
	$(JC) $(JFLAGS) interact/Server_Client_Interface.java server/Server_Object.java server/S$

jar:  interact
	jar cvf interact.jar interact/*.class

clean:
	$(RM) *.class

