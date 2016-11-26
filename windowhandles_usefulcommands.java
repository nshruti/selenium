	package windows;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selpracon_fb2 {
	WebDriver driver;
	String baseUrl1;
	String baseUrl2;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl1 = "https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F";
		baseUrl2 = "http://www.ebay.com/";
	}

	// switch windows
	// getWindowHandles()-get all child windows
	// iterator()--for iteration with parent window and child window
	// driver.switchTo()--driver changes to selected window
	@Test
	public void test() {
		driver.get(baseUrl1);
		driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div/div[1]/p/a")).click();
																							// child
																							// window
		System.out.println(driver.getTitle());
			//  AFTER INVOKING CHILD WINDOW BUT WE STILL GET PARENT TITLE NOT CHILD
												
		Set<String> ids = driver.getWindowHandles();
			// get all windows opened										
		Iterator<String> it = ids.iterator();
												
		String parid = it.next();// it traverse to 1st window i.e; parent
		String childid = it.next();// it traverse to 2nd window i.e; child
		driver.switchTo().window(childid);// switching to child window
											
		System.out.println(driver.getTitle());
		driver.switchTo().window(parid);// switching to parent window 
										
		System.out.println(driver.getTitle());
	}

	@Test
	public void test1() {
		driver.get(baseUrl2);
		System.out.println("links in the page");
		System.out.println(driver.findElements(By.tagName("a")).size());// 568
		System.out.println("links in footer page");
		WebElement footer = driver.findElement(By.xpath(".//*[@id='glbfooter']"));
		System.out.println(footer.findElements(By.tagName("a")).size());// 89
		System.out.println("links in 2nd column of footer page");
		WebElement col = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		int count = col.findElements(By.tagName("a")).size();
		System.out.println(count);// 11
		String Beforeclick = null;
		String Afterclick = null;

		for (int i = 0; i < count; i++) {

			System.out.println(col.findElements(By.tagName("a")).get(i).getText());
			
			if (col.findElements(By.tagName("a")).get(i).getText().contains("Site map")) {
				Beforeclick = driver.getTitle();
				System.out.println("B4 click title is" + Beforeclick);
				col.findElements(By.tagName("a")).get(i).click();
				break;
				}
			}
			Afterclick = driver.getTitle();
			System.out.println("aftr click title is" + Afterclick);

			if (Afterclick != Beforeclick) {
				if (driver.getPageSource().contains("Carsee")) {
					System.out.println("PASS");
				} else {
					System.out.println("FAIL");
			}
		} else {
			System.out.println("After click and before click are same");
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}

// output:
links in the page
568
links in footer page
89
links in 2nd column of footer page
11
Sell
Start selling
Learn to sell
Business sellers
Affiliates
Mobile apps
Downloads
Developers
Security center
eBay official time
Site map
B4 click title isElectronics, Cars, Fashion, Collectibles, Coupons and More | eBay
aftr click title isSitemap | eBay
FAIL
