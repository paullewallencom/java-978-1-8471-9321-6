
package com.binildas.apache.tuscany.sca;

import org.apache.tuscany.sca.host.embedded.SCADomain;

public class BookingAgentClient{

    public static void main(String[] args) throws Exception {

        SCADomain scaDomain = SCADomain.newInstance("BookingAgent.composite");

        IBookingAgent bookingAgent =
            scaDomain.getService(IBookingAgent.class, "BookingAgentServiceComponent");

		System.out.println("BookingAgentClient.bookingTourPackage...");
		String result = bookingAgent.bookTourPackage("20Dec2008", 5, "Economy");
		System.out.println("BookingAgentClient.bookedTourPackage : " + result);

        scaDomain.close();
    }

}
