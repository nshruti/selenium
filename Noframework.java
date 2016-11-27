//login facebook page and enters all the fields required for signup and submits 
package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Noframework {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.facebook.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		// firstname
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("firstname");
		// lastname
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("lastname");
		// email
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("newmail@gmail.com");
		// reenter email
		WebElement emailagain = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		emailagain.sendKeys("newmail@gmail.com");
		// password
		WebElement passwd = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		passwd.sendKeys("github");
		// select month using class called select and we get desired output by
		// value or index
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("4");
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("23");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("2013");
		// select gender
		WebElement gender = driver.findElement(By.id("u_0_d"));
		gender.click();
		// select submit
		WebElement submit = driver.findElement(By.id("u_0_i"));
		submit.click();

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		 driver.quit();
	}

}
