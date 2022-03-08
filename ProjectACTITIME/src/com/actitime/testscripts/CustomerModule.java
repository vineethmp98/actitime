package com.actitime.testscripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generics.ListenerImplementation.class)
public class CustomerModule extends BaseClass{	
	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("createcustomer",true);
		FileLib f=new FileLib();
		String custName = f.getExcelData("CreateCustomer", 2, 2);
		String custDesc = f.getExcelData("CreateCustomer", 2, 3);
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustOption().click();
		t.getCustNameTbx().sendKeys(custName);
		t.getCustDescTbx().sendKeys(custDesc);
		t.getSelCustDD().click();
		t.getOurCompany().click();
		t.getCreateCustBtn().click();
		Thread.sleep(4000);
		String actual = t.getActualCustCreated().getText();
		Assert.assertEquals(actual, custName);
		Reporter.log("Customer is successfully is created",true);
	}
}




