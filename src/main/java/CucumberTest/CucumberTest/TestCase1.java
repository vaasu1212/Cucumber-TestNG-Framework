package CucumberTest.CucumberTest;

import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  DesiredCapabilities dc = DesiredCapabilities.chrome();
	  
		//Proxy proxy = new Proxy();
		//proxy.setHttpProxy("webproxy.virginmoney.com:8081");
		//proxy.setSslProxy("webproxy.virginmoney.com:8081");
		//dc.setCapability("proxy",proxy);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		dc.setCapability(ChromeOptions.CAPABILITY,options);
		 	
		

		//// ChromeDriver driver = new ChromeDriver(capabilities);	 
	        
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
				 driver.get("http://uk.virginmoney.com/");
				 String title1 = driver.getTitle();
				 System.out.println(title1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   // driver = new ChromeDriver();
  //  baseUrl = "http://uk.virginmoney.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCase1() throws Exception {
   // driver.get("http://uk.virginmoney.com/");
    driver.findElement(By.xpath("//a[@id='product-nav']/span")).click();
    driver.findElement(By.xpath("//a[@id='navbarDropdownCurrentaccounts']/div/span")).click();
    driver.findElement(By.xpath("//ul[@id='navbarNavDropdown']/li/nav/div/ul/li/a/span")).click();
    driver.findElement(By.xpath("//a[@id='product-nav']/span")).click();
    driver.findElement(By.xpath("//a[@id='navbarDropdownSavings']/div/span")).click();
    driver.findElement(By.xpath("//ul[@id='navbarNavDropdown']/li[2]/nav/div/ul/li/a/span")).click();
    driver.findElement(By.cssSelector("h3.card-title.h3")).click();
    driver.findElement(By.xpath("//tr[@id='1_year_fixed_rate_cash_e_isa_issue_387']/td/a")).click();
    Thread.sleep(5000);
    Assert.assertEquals(driver.findElement(By.cssSelector("h1.h1.display-2")).getText(), "1 Year Fixed Rate Cash E‑ISA");
   
    driver.findElement(By.linkText("Please read the Summary Box")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("span.accordion__icon")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("span.accordion__icon")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
