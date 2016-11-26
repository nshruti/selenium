
//here we are trying to export element (id,name) and here we enter the keys using "send keys"
package generic;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getelement {
	WebDriver driver;
	String baseUrl1;
	private Genericdemo gm;// declare class we created here

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://www.facebook.com/";
		gm = new Genericdemo(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void test() {
		driver.get(baseUrl1);
		// way to find the element
		// WebElement element=driver.findElement(By.id("u_0_1"));
		// we find the elements from the function "getelement" in "Genericdemo"
		// class
		WebElement element = gm.getelement("u_0_1", "id");
		element.sendKeys("test");

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
//output:Element found with id: u_0_1