
package com.binildas.apache.tuscany.sca;

public class FlightServiceImpl implements IFlightService{

    public String bookFlight(String date, int seats, String flightClass){
		System.out.println("FlightServiceImpl.bookFlight...");
		return "Success";
    }

}
