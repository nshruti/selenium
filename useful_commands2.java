package testingpractice;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

public class Selpracon_fb1 {
	WebDriver driver;
	String baseUrl1;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "http://www.tizag.com/javascriptT/javascriptalert.php";
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	// switchTo(),accept(),dismiss(),getText()
	@Test
	public void test() {
		driver.get(baseUrl1);
		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
		System.out.println(driver.switchTo().alert().getText());// this changes
																// driver to
																// alert mode
																// and get alert
																// text
		// driver.switchTo().alert().sendKeys("fesfe");
		driver.switchTo().alert().accept(); // Accept = ok done yes
		// driver.switchTo().alert().dismiss();//dismiss=cancel
	}

	// Delete Cookies
	@Test
	public void test1() {
		WindowsUtils.tryToKillByName("notepad.exe");// when we testing it helps
													// to kill all notepad pages
													// automatically
		driver.get("http://google.com");
		Set<Cookie> cookie_names = driver.manage().getCookies();// get all
																// cookies
		System.out.println(cookie_names.size());
		driver.manage().deleteAllCookies();// delete all cookies
		Set<Cookie> cookie_names_again = driver.manage().getCookies();
		System.out.println(cookie_names_again.size());
	}

}
OUTPUT
Are you sure you want to give us the deed to your house?
1
0