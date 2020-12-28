

package com.binildas.apache.axis.AxisSpring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client{

    private ApplicationContext ctx;
    private ClientObject clientObject;

   public Client(){
        String[] paths = {"/applicationContextClient.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        clientObject = (ClientObject) ctx.getBean("clientObject");

   }

   public void finalize()throws Throwable{
	   super.finalize();
	   clientObject = null;
	   ctx = null;
   }

   private void test1(){
	   log("Client.main() : test1...");
       log(clientObject.hello("Binil"));
   }

    public static void main(String[] args)throws Exception{
       log("Client.main() : Start...");
         Client client = new Client();
         client.test1();
       log("Client.main() : End...");
    }

	private static final void log(Object message){
		System.out.println(message.toString());
	}
}
