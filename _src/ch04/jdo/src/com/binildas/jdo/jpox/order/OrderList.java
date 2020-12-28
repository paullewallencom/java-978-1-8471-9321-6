
package com.binildas.jdo.jpox.order;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;
import java.util.Date;

public class OrderList{

    private int number;
	private Date orderDate;
    private Set lineItems;
	public OrderList(){
	}

	public OrderList(int number, Date orderDate){
		this.number = number;
		this.orderDate = orderDate;
	}

	public void setNumber(int i) {
		number = i;
	}

    public int getNumber(){
        return number;
    }

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

    public Date getOrderDate(){
        return orderDate;
    }

	public void setLineItems(Set lineItems) {
		this.lineItems = lineItems;
	}

	public Set getLineItems() {
		if(null == lineItems){
			lineItems = new HashSet();
		}
		return lineItems;
	}

	public String toString(){
		return String.valueOf(number);
	}

	// Inner class for composite PK
	public static class Oid implements Serializable{

		public int number;

		public Oid(){
		}

		public Oid(int param){
			this.number = param;
		}

		public String toString(){
			return String.valueOf(number);
		}

		public int hashCode(){
			return number;
		}

		public boolean equals(Object other){

			if (other != null && (other instanceof Oid)){
				Oid k = (Oid)other;
				return k.number == this.number;
			}
			return false;
		}
	}
}