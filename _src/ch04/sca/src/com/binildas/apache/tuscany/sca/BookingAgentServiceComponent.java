
package com.binildas.apache.tuscany.sca;

import org.osoa.sca.annotations.Reference;

public class BookingAgentServiceComponent implements IBookingAgent{

    private IFlightService flightService;
    private IHotelService hotelService;
    private ICabService cabService;

    @Reference
    public void setFlightService(IFlightService flightService) {
        this.flightService = flightService;
    }

    @Reference
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Reference
    public void setCabService(ICabService cabService) {
        this.cabService = cabService;
    }

    public String bookTourPackage(String date, int people, String tourPack){
		System.out.println("BookingAgentServiceComponent.bookTourPackage...");

		String flightBooked = flightService.bookFlight(date, people, tourPack);
		String hotelBooked = hotelService.bookHotel(date, people, tourPack);
		String cabBooked = cabService.bookCab(date, tourPack);

		if((flightBooked.equals("Success")) && (hotelBooked.equals("Success")) && (cabBooked.equals("Success"))){
			return "Success";
		}
		else{
			return "Failure";
		}
	}

}
