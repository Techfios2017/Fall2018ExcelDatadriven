package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContact;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;
import util.Xls_Reader;

public class AddContactTest {

Xls_Reader reader=new Xls_Reader("/Users/eldrid/SeleniumReview/xldatadriven/Data/Fall2018java.xlsx");
	
String Loginemail=reader.getCellData("Sheet1", "Loginemail", 2);
String password=reader.getCellData("Sheet1", "password", 2);
String Name=reader.getCellData("Sheet1", "Name", 2);
String Company=reader.getCellData("Sheet1", "Company", 2);
String Email=reader.getCellData("Sheet1", "Email", 2);
String phone=reader.getCellData("Sheet1", "phone", 2);
String address=reader.getCellData("Sheet1", "address", 2);
String City=reader.getCellData("Sheet1", "City", 2);
String State=reader.getCellData("Sheet1", "State", 2);
String Zip=reader.getCellData("Sheet1", "Zip", 2);


@Test
public void AddingContact()throws InterruptedException{

	WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");	
	
	LoginPage logintotechfios= PageFactory.initElements(driver, LoginPage.class);

	logintotechfios.Login(Loginemail, password);
	
	HomePage home= PageFactory.initElements(driver, HomePage.class);
	
	home.NavigateToAddContact();
	
	AddContact contact=PageFactory.initElements(driver, AddContact.class);
	
	contact.FillingUpAdressForm(Name, Company, Email, phone, address, City, State, Zip);

	driver.close();
	
	driver.quit();
	
	
}

}
