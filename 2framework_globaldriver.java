package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class 2frameworktestcase_globaldriver {
	WebDriver driver;
	String baseUrl;
	L109Searchpage_gldrive sch;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.facebook.com/";
		sch = new L109Searchpage_gldrive(driver);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() {
		sch.fillfirstname("first");
		sch.filllastname("last");
		sch.fillemail("sampleid@gmail.com");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
