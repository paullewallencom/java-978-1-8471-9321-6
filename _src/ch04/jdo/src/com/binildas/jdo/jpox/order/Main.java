package com.binildas.jdo.jpox.order;

import java.io.FileInputStream;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.util.Date;

public class Main{

    static public void main(String[] args){

        Properties props = new Properties();
        try{
            props.load(new FileInputStream("jpox.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(props);

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        Object id = null;
        try{
            tx.begin();

            LineItem lineItem1 = new LineItem("CD011", 1);
            LineItem lineItem2 = new LineItem("CD022", 2);
            OrderList orderList = new OrderList(1, new Date());
            orderList.getLineItems().add(lineItem1);
            orderList.getLineItems().add(lineItem2);

            LineItem lineItem3 = new LineItem("CD033", 3);
            LineItem lineItem4 = new LineItem("CD044", 4);
            OrderList orderList2 = new OrderList(2, new Date());
            orderList2.getLineItems().add(lineItem3);
            orderList2.getLineItems().add(lineItem4);

            pm.makePersistent(orderList);
            id = pm.getObjectId(orderList);
            System.out.println("Persisted id : "+ id);

            pm.makePersistent(orderList2);
            id = pm.getObjectId(orderList2);
            System.out.println("Persisted id : "+ id);

            orderList = (OrderList) pm.getObjectById(id);
            System.out.println("Retreived orderList : " + orderList);

            System.out.println("Persistent : "+JDOHelper.isPersistent(orderList));
            System.out.println("Dirty : "+JDOHelper.isDirty(orderList));
            System.out.println("New : "+JDOHelper.isNew(orderList));
            System.out.println("Transactional : "+JDOHelper.isTransactional(orderList));
            System.out.println("Deleted : "+JDOHelper.isDeleted(orderList));

            tx.commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            if (tx.isActive()){
                tx.rollback();
            }
        }
        finally{
            pm.close();
        }
    }
}
