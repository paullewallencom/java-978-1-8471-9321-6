As a first step, edit examples.PROPERTIES provided along with the code download for this chapter and change the paths there to match your development environment.

1. Web Service Implementation in Java SE 6
==========================================
Folder: ch03\01_JaxWS\JavaStandAlone

To Run the Server
-----------------
cd ch03\01_JaxWS\JavaStandAlone
ant server

To Run the Client
-----------------
cd ch03\01_JaxWS\JavaStandAlone
ant client

2. Web Service Implementation in Java EE Server
===============================================
Folder: ch03\01_JaxWS\JavaEEServer

To Run the Server and Client
----------------------------
To start the Java EE Server default domain, select the ‘Start Default Server’ option from the Programs menu:
Start -> All Programs -> Sun Microsystems -> Java EE 5 SDK -> Start Default Server
Now you can verify whether your server is up by typing: http://127.0.0.1:8080/

Assuming your Java EE server is up and running, execute the following commands which will deploy the web service and also execute the test client.

cd ch03\01_JaxWS\JavaEEServer
ant

3. Web Service using Apache Axis
================================
Folder: ch03\02_Axis

To Run the Server
-----------------
cd ch03\02_Axis
ant

Move ch03\02_Axis\dist\AxisEndToEnd.war to the webapps folder of your web server and restart your web server if required.
Test whether your web service deployment went fine by typing the URL in your web browser: http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL

To Run the Client
-----------------
To execute the RpcClient, execute following commands:
cd ch03\02_Axis
ant runrpc

To execute the CallClient, execute following commands:
cd ch03\02_Axis
ant runcall

4. Web Service using Spring
===========================
Folder: ch03\03_Spring

To Run the Server
-----------------
cd ch03\03_Spring
ant

Move ch03\03_Spring\WebService\dist\AxisSpring.war to the webapps folder of your web server and restart your web server if required.
Test whether your web service deployment went fine by typing the URL in your web browser: http://localhost:8080/AxisSpring/services/HelloWebService?wsdl

To Run the Client
-----------------
cd ch03\03_Spring
ant run

5. Web Service using XFire
==========================
Folder: ch03\04_XFire

To Run the Server
-----------------
cd ch03\04_XFire
ant

Move ch03\04_XFire\dist\HelloXFire.war to the webapps folder of your web server and restart your web server if required.
Test whether your web service deployment went fine by typing the URL in your web browser:  http://localhost:8080/HelloXFire/services/Hello?wsdl

To Run the Client
-----------------
cd ch03\04_XFire
ant run

