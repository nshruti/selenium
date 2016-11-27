package herokuapp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload_file {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		String filename = "texting.txt";
		File file = new File(filename);
		String path2 = file.getAbsolutePath();// get path of file
		System.out.println("path is: " + path2);// C:\\Users\\pinup\\Desktop
		driver.get("http://the-internet.herokuapp.com/upload");
		System.out.println(driver.getCurrentUrl());// http://the-internet.herokuapp.com/upload
		driver.findElement(By.id("file-upload")).sendKeys(path2);
		WebElement clicker = driver.findElement(By.id("file-submit"));
		clicker.click();
		System.out.println(driver.getCurrentUrl());// http://the-internet.herokuapp.com/upload
		String text = driver.findElement(By.id("uploaded-files")).getText();
		System.out.println("tesxt is: " + text);// texting.txt
		// assertThat(text, is(equalTo(filename)));
	}

}
