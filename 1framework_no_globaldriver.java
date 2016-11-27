package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L107framework_noglobaldriver {

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

		L107Searchpage_nogldrive.fillfirstname(driver, "first");
		L107Searchpage_nogldrive.filllastname(driver, "last");
		L107Searchpage_nogldrive.fillemail(driver, "sampleid@gmail.com");
		L107Searchpage_nogldrive.fillreemail(driver, "sampleid@gmail.com");
		L107Searchpage_nogldrive.month(driver, "4");

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
