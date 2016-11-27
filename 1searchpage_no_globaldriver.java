package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class L107Searchpage_nogldrive {
	public static WebElement element = null;
	public static Select month;

	public static WebElement firstname(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='firstname']"));
		return element;
	}

	public static void fillfirstname(WebDriver driver, String first) {
		element = firstname(driver);
		element.sendKeys(first);
	}

	public static WebElement lastname(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='lastname']"));
		return element;
	}

	public static void filllastname(WebDriver driver, String last) {
		element = lastname(driver);
		element.sendKeys(last);
	}

	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		return element;
	}

	public static void fillemail(WebDriver driver, String email) {
		element = email(driver);
		element.sendKeys(email);
	}

	public static WebElement reemail(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		return element;
	}

	public static void fillreemail(WebDriver driver, String email) {
		element = reemail(driver);
		element.sendKeys(email);
	}

	public static void month(WebDriver driver, String value) {
		month = new Select(driver.findElement(By.id("month")));
		month.selectByValue(value);
	}

}
