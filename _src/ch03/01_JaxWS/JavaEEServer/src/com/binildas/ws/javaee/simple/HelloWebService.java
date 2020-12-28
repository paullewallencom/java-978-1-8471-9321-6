
package com.binildas.ws.javaee.simple;

import javax.jws.WebService;

@WebService
public class HelloWebService{

	private static int times;

	public HelloWebService(){
		System.out.println("Inside HelloWebService.HelloWebService...");
	}


	public String hello(String param){

		System.out.println("Inside HelloWebService.hello... - " + (++times));
		return "Return From Server : Hello " + param;
	}

}

//		http://localhost:8080/HelloWebService/HelloWebServiceService?WSDL


