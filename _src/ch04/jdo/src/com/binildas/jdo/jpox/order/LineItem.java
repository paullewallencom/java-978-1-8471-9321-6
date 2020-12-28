
package com.binildas.jdo.jpox.order;

public class LineItem{

  private String productId;
  private int numberOfItems;
  private OrderList orderList;

  public LineItem(){
  }

  public LineItem(String productId, int numberOfItems){
	  this.productId = productId;
	  this.numberOfItems = numberOfItems;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }

  public void setNumberOfItems(int numberOfItems) {
    this.numberOfItems = numberOfItems;
  }

  public int getNumberOfItems() {
    return numberOfItems;
  }

  public void setOrderList(OrderList orderList){
	  this.orderList = orderList;
  }
  public OrderList getOrderList(){
	  return orderList;
  }

}