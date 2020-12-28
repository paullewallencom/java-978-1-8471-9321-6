
package com.binildas.apache.tuscany.sdo;

import java.util.List;
import java.io.*;

import org.apache.tuscany.samples.sdo.SampleBase;
import org.apache.tuscany.samples.sdo.internal.SampleInfrastructure;

import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

public class ReadEmployees extends SampleBase{

	private static final String HR_XML_RESOURCE = "hr.xml";
	public static final String HR_XSD_RESOURCE = "hr.xsd";

    public ReadEmployees(Integer commentaryLevel) {
      super(commentaryLevel, SampleInfrastructure.SAMPLE_LEVEL_BASIC);
    }

	public static void main(String[] args)throws Exception{

		ReadEmployees sample = new ReadEmployees(COMMENTARY_FOR_NOVICE);
		sample.runSample();
	}

    public void runSample () throws Exception{

		InputStream inputStream = ClassLoader.getSystemResourceAsStream(HR_XML_RESOURCE);
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		inputStream.close();

        HelperContext scope = createScopeForTypes();
        loadTypesFromXMLSchemaFile(scope, HR_XSD_RESOURCE);
        XMLDocument xmlDoc = getXMLDocumentFromString(scope, new String(bytes));
        DataObject purchaseOrder = xmlDoc.getRootObject();

        List itemList = purchaseOrder.getList("employee");
        DataObject item = null;
        for (int i = 0; i < itemList.size(); i++) {

            item = (DataObject) itemList.get(i);

            System.out.println("id: " + item.get("id"));
            System.out.println("name: " + item.get("name"));
        }
    }
}
