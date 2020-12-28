
package com.binildas.apache.axis.AxisSpring;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

public class HelloWebService extends ServletEndpointSupport implements IHelloWeb{

	private IHello iHello;

	public HelloWebService(){
		System.out.println("Inside HelloWebService.HelloWebService...");
	}

	protected void onInit() {
		System.out.println("Inside HelloWebService.onInit...");
		this.iHello = (IHello) getWebApplicationContext().getBean("hello");
	}


	public void setHello(IHello iHello){
		this.iHello = iHello;
	}

	public String hello(String param){

		System.out.println("Inside HelloWebService.hello...");
		return iHello.hello(param);
	}

}

//		http://localhost:8080/springaxis/services/helloservice?WSDL

//		http://localhost:8080/springaxis/helloservice?WSDL

