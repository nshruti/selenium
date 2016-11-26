//here we exporting locator ant type and we get true or false by knowing size of elemnents if its >0 its true or flase

package generic;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iselementpresent_84 {
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

		boolean res1 = gm.iselementpresent("u_0_1", "id");
		System.out.println("Is element present: " + res1); // output is true
		boolean res2 = gm.iselementpresent("name_not", "id");
		System.out.println("Is element present: " + res2); // output is false

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
//output:Element found with id: u_0_1
//Is element present: true
