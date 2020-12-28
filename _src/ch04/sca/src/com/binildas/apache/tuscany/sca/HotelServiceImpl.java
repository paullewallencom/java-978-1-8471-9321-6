
package com.binildas.apache.tuscany.sca;

public class HotelServiceImpl implements IHotelService{

    public String bookHotel(String date, int beds, String hotelClass){
		System.out.println("HotelServiceImpl.bookHotel...");
		return "Success";
    }

}
