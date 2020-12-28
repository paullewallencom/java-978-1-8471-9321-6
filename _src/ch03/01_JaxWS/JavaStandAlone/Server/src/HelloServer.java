
package com.binildas.ws.javastandalone.simple;

import javax.xml.ws.Endpoint;

public class HelloServer {

  public static void main(String args[]) {

	  log("HelloServer.main : Creating HelloImpl...");
	  IHello iHello = new HelloImpl();

	try{

		// Create and publish the endpoint at the given address
		log("HelloServer.main : Publishing HelloImpl...");
		Endpoint endpoint1 = Endpoint.publish("http://localhost:8080/Hello", iHello);
		log("HelloServer.main : Published Implementor...");


	}
	catch (Exception e) {
		System.err.println("ERROR: " + e);
		e.printStackTrace(System.out);
	}

	System.out.println("HelloServer Exiting ...");

	}

    private static final void log(Object msg){
		System.out.println(msg.toString());
	}


}
