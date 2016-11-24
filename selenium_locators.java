//open browser
System.setProperty("webdriver.chrome.driver","C:\\Users\\pinup\\Desktop\\code\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();n 
//Go to specified URL
driver.get("http://www.google.com/");
//Locating Elements
1.BY Id
<input id="q">...</input>
element=driver.findElement(By.id("q"));
2.BY Class Name
<div class="highlight-java" style="display: none; ">...</div>
element=driver.findElement(By.className("highlight-java"));
3.BY Tagname
<div class="highlight-java" style="display: none; ">...</div>
element=driver.findElement(By.tagName("div"));
4.By Name
<input id="q" name='search' type='text'>…</input>
element=driver.findElement(By.name("search"));
5.By Linktext
<a href="http://www.google.com/search?q=cheese">cheese</a>
element=driver.findElement(By.linkText("cheese"));
6.By Partial Link Text
<a href="http://www.google.com/search?q=cheese">search for cheese</a>  
element=driver.findElement(By.partialLinkText("cheese"));
7.By Css Name
<div id="food">
 <span class="dairy" id="product">milk</span>
 <span class="dairy aged">cheese</span>
</div>
 7.1.css selector for an element using Id:
     element=driver.findElement(By.cssSelector("#product"));
 7.2.css selector for an element using Class:
     element=driver.findElement(By.cssSelector(".dairy"));
 7.3.css selector for a span using Id
     element=driver.findElement(By.cssSelector("span#product"));
 7.4.css selector for a span using class
     element=driver.findElement(By.cssSelector("span.dairy aged"));
 7.5.css selector for a selecting element inside another element
     lement=driver.findElement(By.cssSelector("div#food span.dairy aged"));
8.By XPath
  SYNTAX:"//tag[@attribute='value']"
     element=driver.findElement(By.xpath("//span[@class='dairy']"));
  Relative	xpath	using	single	‘/’	:
     "//div[@id='navbar']/div/div/div/ul/li[2]/a"//signifies to look for the element immediately inside the	parent element.
  Relative	xpath	using	double '//' :
     "//div[@id='navbar']//ul/li[2]/a"//signifies to look for any child or nested child element	inside the parent element.
  Signifies to look for any child or nested child element	inside the parent element:
     "//div[@id='navbar']//a[text()='enroll']"
  Using	Contains	to	find	the	elements:
      "//div[@id='navbar']//a[contains(text(),'Login')]"
      "//div[@id='navbar']//a[contains(@class,'navbar-link')	and	contains(@href,'sign_in')]"
  
  CSS Selector:
  element=driver.findElement(By.xpath("span[class='dairy']"));
