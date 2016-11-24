package testingpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selpracon_fb {
	WebDriver driver;
	String baseUrl1;
	String baseUrl2;
	String baseUrl3;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://www.facebook.com/";
		baseUrl2 = "https://www.expedia.com/";
		baseUrl3 = "https://www.amazon.com";
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//close the browser
	}

	// is
	// dispalyed(),sendkeys(),click(),clear(),getAttribute(),getTagName(),selectByValue(),deselectByValue()
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl1);
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		System.out.println(firstname.isDisplayed());
		firstname.sendKeys("shruti");
		WebElement gender = driver.findElement(By.id("u_0_d"));
		gender.click();
		Thread.sleep(3000);
		firstname.clear();
		System.out.println(firstname.getAttribute("name"));// "firstname"
		System.out.println(firstname.getTagName());// input
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("4");
		// month.deselectByValue("4");
	}

	@Test
	// display all the values of the dropdown using"GETOPTIONS" in sel1
	// get the text using "GET TEXT"
	public void test1() throws InterruptedException {
		driver.get(baseUrl2);
		Select sel1 = new Select(driver.findElement(By.id("package-1-children")));
		List<WebElement> options = sel1.getOptions();
		// stores the values in "options" list
		int size = options.size();
		for (int i = 0; i < size; i++) {
			String optionname = sel1.getOptions().get(i).getText();
			System.out.println(optionname);

		}
	}

	// mouse hover,
	@Test
	public void test2() throws InterruptedException {
		driver.get(baseUrl3);
		Actions toprime = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
		// moves the cursor to the object called "element" which has xpath in it
		toprime.moveToElement(element).build().perform();

		

	}
}
