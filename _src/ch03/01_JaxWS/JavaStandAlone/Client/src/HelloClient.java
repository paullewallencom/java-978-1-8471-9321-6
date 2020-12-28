
package com.binildas.ws.javastandalone.simple;

import java.net.URL;
import javax.xml.namespace.QName;


public class HelloClient{


  public static void main(String args[]) {

	  log("HelloClient.main : Creating HelloImpl...");
	  HelloService helloService = null;
	  IHello helloImpl = null;
	  String gotFromServer = null;

	try{

		log("HelloClient.main : Creating HelloImplService...");
		if(args.length != 0){
			helloService = new HelloService(new URL(args[0]), new QName(args[1], args[2]));
		}
		else{
			helloService = new HelloService();
		}
		log("HelloClient.main : Retreiving HelloImpl...");
		helloImpl = helloService.getIHelloPort();
		log("HelloClient.main : Invoking helloImpl.sayHello(\"Binil\")...");
		gotFromServer = helloImpl.sayHello("Binil");
		log("HelloClient.main : gotFromServer : " + gotFromServer);


	}
	catch (Exception e) {
		System.err.println("ERROR: " + e);
		e.printStackTrace(System.out);
	}

	}

    private static final void log(Object msg){
		System.out.println(msg.toString());
	}


}
