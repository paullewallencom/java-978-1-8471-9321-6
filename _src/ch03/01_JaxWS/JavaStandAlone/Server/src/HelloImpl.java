
package com.binildas.ws.javastandalone.simple;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebMethod;

@WebService(name="IHello", serviceName="HelloService")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class HelloImpl implements IHello {


	@WebMethod(operationName = "sayHello")
	public String sayHello(String name) {

		System.out.println("HelloImpl.sayHello...");
		return "\nHello From Server !! : " + name;
	}

}
