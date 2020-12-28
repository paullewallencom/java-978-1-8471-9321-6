
package com.binildas.apache.axis.AxisEndToEnd;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;

import com.binildas.apache.axis.AxisEndToEnd.IHelloWebService;
import com.binildas.apache.axis.AxisEndToEnd.IHelloWebServiceLocator;
import com.binildas.apache.axis.AxisEndToEnd.IHelloWeb;

public class RpcClient{

    private static String wsdlUrl = "http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL";
    private static String namespaceURI = "http://AxisEndToEnd.axis.apache.binildas.com";
    private static String localPart = "IHelloWebService";

    protected void executeClient(String[] args)throws Exception{

		log(" ********** RpcClient.executeClient...");

		IHelloWebService iHelloWebService = null;
		IHelloWeb iHelloWeb = null;

		if(args.length == 3){
			iHelloWebService = new IHelloWebServiceLocator(args[0], new QName(args[1], args[2]));
		}
		else{
			iHelloWebService = new IHelloWebServiceLocator(wsdlUrl, new QName(namespaceURI, localPart));
		}

		iHelloWeb = iHelloWebService.getHelloWebService();

		log("Response From Server : " + iHelloWeb.hello("Binil"));

	}

    public static void log(Object msg){
       System.out.println(msg.toString());
    }

    public static void main(String[] args)throws Exception{

		log(" ********** RpcClient.main-Start...");

		RpcClient client = new RpcClient();
		client.executeClient(args);

		log(" ********** RpcClient.main-Done.");
	}

}