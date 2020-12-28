
package com.binildas.apache.axis.AxisSpring;

public class Hello implements IHello{

	public Hello(){
		System.out.println("Inside Hello.Hello...");
	}

	public String hello(String param){

		System.out.println("Inside Hello.hello...");
		return "Hello " + param;
	}

}