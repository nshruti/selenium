package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class 2Searchpage_gldrive {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@name='reg_email__']")
	WebElement email;

	@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
	WebElement reemail;

	public L109Searchpage_gldrive(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillfirstname(String first) {
		firstname.sendKeys(first);
	}

	public void filllastname(String last) {
		lastname.sendKeys(last);
	}

	public void fillemail(String emailname) {
		email.sendKeys(emailname);
	}

}
