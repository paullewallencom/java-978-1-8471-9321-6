
package com.binildas.ws.javaee.simple;

import javax.xml.ws.WebServiceRef;

public class Client{

    @WebServiceRef(wsdlLocation="http://localhost:8080/HelloWebService/HelloWebServiceService?WSDL")
    static HelloWebServiceService service;

    public static void main(String[] args){
        Client client = new Client();
        client.test();
    }

    public void test(){

        try{
            HelloWebService helloWebServicePort = service.getHelloWebServicePort();
            String ret = helloWebServicePort.hello(System.getProperty("user.name"));
            System.out.println("Hello result = " + ret);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
