  //It helps to export locator and type to genericdemo and get the element list and here we find size of the list

package generic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getelementlist_83 {
	WebDriver driver;
	String baseUrl1;
	private Genericdemo gm;// declare class we created here

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://letskodeit.teachable.com/p/practice";
		// https://letskodeit.teachable.com/p/practice
		gm = new Genericdemo(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void test() {
		driver.get(baseUrl1);

		List<WebElement> elementlist = gm.getelementlist("input[@name='firstname']", "xpath");
		int size = elementlist.size();
		System.out.println("the size of the element is " + size);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
//output:Element not found with xpath: input[@name='firstname']
//the size of the element is 0