
package com.binildas.apache.axis.AxisEndToEnd;

public class HelloWebService implements IHelloWeb{

	private static int times;

	public HelloWebService(){
		System.out.println("Inside HelloWebService.HelloWebService...");
	}

	public String hello(String param){

		System.out.println("Inside HelloWebService.hello... - " + (++times));
		return "Return From Server";
	}

}

//		http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL


