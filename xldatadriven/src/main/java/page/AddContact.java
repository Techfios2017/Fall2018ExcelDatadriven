package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddContact {
	
	WebDriver driver;

	public AddContact (WebDriver ldriver){
		this.driver=ldriver;
	}

	@FindBy(how=How.ID,using="account")
	WebElement fullname;
	
	@FindBy(how=How.ID,using="company")
	WebElement name;
	
	@FindBy(how=How.ID,using="email")
	WebElement email;
	
	@FindBy(how=How.ID,using="phone")
	WebElement phone;
	
	@FindBy(how=How.ID,using="address")
	WebElement address;
	
	@FindBy(how=How.ID,using="city")
	WebElement city;
	
	@FindBy(how=How.ID,using="state")
	WebElement state;
	
	@FindBy(how=How.ID,using="zip")
	WebElement zip;
	
	@FindBy(how=How.ID,using="submit")
	WebElement submitbutton;
	
	
	public void FillingUpAdressForm(String FName,String CName,String Email, String Phone,String Address,String City,String State,String Zip){
		
	fullname.sendKeys(FName);
	name.sendKeys(CName);
	email.sendKeys(Email);
	phone.sendKeys(Phone);
	address.sendKeys(Address);
	city.sendKeys(City);
	state.sendKeys(State);
	zip.sendKeys(Zip);
	submitbutton.click();
	}
}
