
package com.binildas.apache.tuscany.sca;

public class CabServiceImpl implements ICabService{

    public String bookCab(String date, String cabType){
		System.out.println("CabServiceImpl.bookCab...");
		return "Success";
    }

}
