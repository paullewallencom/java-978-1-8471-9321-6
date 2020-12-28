
package com.binildas.apache.axis.AxisSpring;

import java.util.List;

public class ClientObject{

	private IHello helloService;

	public void setHelloService(IHello helloService) {
		this.helloService = helloService;
	}

	public String hello(String param) {
		log("ClientObject.hello");
		return helloService.hello(param);
	}

	private static final void log(Object message){
		System.out.println(message.toString());
	}

}