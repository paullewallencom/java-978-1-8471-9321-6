
package com.binildas.apache.tuscany.sdo;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

public class CreateEmployees extends SampleBase {

	private static final String HR_XML_RESOURCE_NEW = "hr_new.xml";
	public static final String HR_XSD_RESOURCE = "hr.xsd";
    public static final String HR_NAMESPACE = "http://www.binildas.com/apache/tuscany/sdo/sample";

    public CreateEmployees(Integer commentaryLevel) {
      super(commentaryLevel, SAMPLE_LEVEL_BASIC);
    }

    public static void main(String[] args) throws Exception{

      CreateEmployees sample = new CreateEmployees(COMMENTARY_FOR_NOVICE);
      sample.runSample();
    }

    public void runSample() throws Exception{


          HelperContext scope = createScopeForTypes();

        	loadTypesFromXMLSchemaFile(scope, HR_XSD_RESOURCE);


          DataFactory factory = scope.getDataFactory();
          DataObject purchaseOrder = factory.create(HR_NAMESPACE, "employees");


          DataObject employee1 = purchaseOrder.createDataObject("employee");
          employee1.setString("id", "3457");
          employee1.set("name", "Cindy Jones");
          DataObject homeAddress1 = employee1.createDataObject("address");
          homeAddress1.set("street1", "Cindy Jones");
          homeAddress1.set("city", "Stanchion");
          homeAddress1.set("state", "TX");
          homeAddress1.set("zip-code", "79021");
          DataObject organization1 = employee1.createDataObject("organization");
          organization1.setString("id", "78");
          organization1.set("name", "Sales");
          DataObject office1 = employee1.createDataObject("office");
          office1.setString("id", "43");
          DataObject officeAddress1 = office1.createDataObject("address");
          officeAddress1.set("street1", "567 Murdock");
          officeAddress1.set("street2", "Suite 543");
          officeAddress1.set("city", "Millford");
          officeAddress1.set("state", "TX");
          officeAddress1.set("zip-code", "79025");

          DataObject employee2 = purchaseOrder.createDataObject("employee");
          employee2.setString("id", "30376");
          employee2.set("name", "Linda Mendez");
          DataObject homeAddress2 = employee1.createDataObject("address");
          homeAddress2.set("street1", "423 Black Lake Road");
          homeAddress2.set("street2", "Appartment 7A");
          homeAddress2.set("city", "Boston");
          homeAddress2.set("state", "MA");
          homeAddress2.set("zip-code", "20967");
          DataObject organization2 = employee2.createDataObject("organization");
          organization2.setString("id", "78");
          organization2.set("name", "HR");
          DataObject office2 = employee2.createDataObject("office");
          office2.setString("id", "48");
          DataObject officeAddress2 = office2.createDataObject("address");
          officeAddress2.set("street1", "5666 Cambridge Drive");
          officeAddress2.set("city", "Boston");
          officeAddress2.set("state", "MA");
          officeAddress2.set("zip-code", "20968");

          OutputStream stream = new FileOutputStream(HR_XML_RESOURCE_NEW);
          scope.getXMLHelper().save(purchaseOrder, HR_NAMESPACE, "employees", stream);
          stream.close();

          XMLDocument doc = scope.getXMLHelper().createDocument(purchaseOrder, HR_NAMESPACE, "employees");
          scope.getXMLHelper().save(doc, System.out, null);
          System.out.println();

      }
}
