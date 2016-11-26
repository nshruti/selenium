package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());// we can view pagesource of
													// the website
		System.out.println("switched");
		// prints the total number of frames and their names
		List<WebElement> ele = driver.findElements(By.tagName("frame"));
		System.out.println("Number of frames in a page :" + ele.size());
		for (WebElement el : ele) {
			// Returns the Name of a frame.
			System.out.println("Frame name :" + el.getAttribute("name"));
		}

		WebElement fr = driver.findElement(By.name("login_page"));
		driver.switchTo().frame(fr);
		// driver.switchTo().frame(1);// to switch frame by id and the id starts
		// with 0
		driver.findElement(By.xpath("//input[@class='input_password']")).sendKeys("shruti");
		driver.quit();

	}

}

OUTPUT
https://netbanking.hdfcbank.com/netbanking/
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>Welcome to HDFC Bank NetBanking</title>
<script language="javascript">
	var daemon			= 'NETBANKING';
	var p_remoteaddress	= '';
	var RsaAuthReq		= '';
	
	var l_path = window.location.pathname;

	if(l_path == undefined || l_path == '' || l_path.indexOf("/netbanking") &lt; 0){
		window.location.href = window.location.protocol + "//" + window.location.host +"/netbanking";
	}

</script>
</head>
	<frameset border="false" frameborder="O" framespacing="0" rows="*" cols="*">
		<frameset border="false" frameborder="O" framespacing="0" rows="*,30" cols="*">
			<frame marginwidth="0" marginheight="0" name="login_page" src="RSLogin.html?v=7" noresize="true" scrolling="yes" />
			<frame marginwidth="0" marginheight="0" name="footer" src="footer.html" noresize="true" scrolling="no" />
		</frameset>
	</frameset>

</html>
switched
Number of frames in a page :2
Frame name :login_page
Frame name :footer
