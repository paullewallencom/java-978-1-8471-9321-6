package com.binildas.apache.axis.AxisEndToEnd;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPEnvelope;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

public class CallClient {

	public static String wsURL = "http://localhost:8080/AxisEndToEnd/services/HelloWebService?WSDL";
	public static String action = "HelloWebService";

	public static String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:hello soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://AxisEndToEnd.axis.apache.binildas.com\"><in0 xsi:type=\"soapenc:string\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">Binil</in0></ns1:hello></soapenv:Body></soapenv:Envelope>";

    public static void test() throws Exception{

      InputStream input = new ByteArrayInputStream(msg.getBytes());
      Service service = new Service();
      Call call = (Call) service.createCall();
      SOAPEnvelope soapEnvelope = new SOAPEnvelope(input);

      call.setTargetEndpointAddress( new URL(wsURL) );
      if (action != null) {
          call.setUseSOAPAction( true );
          call.setSOAPActionURI( action );
      }

      soapEnvelope = call.invoke( soapEnvelope );

      System.out.println( "Response:\n" + soapEnvelope.toString() );
    }

	public static void main(String args[]) throws Exception{

		CallClient callClient = new CallClient();
		if(args.length > 0){
			wsURL = args[0];
		}
		if(args.length > 1){
			action = args[1];
		}
		callClient.test();
	}
}
