package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

	RemoteWebDriver driver;

	
	 @Given("^User launches feature2 application$")
	 public void user_already_on_login_page1(){
		System.out.println("Feature2 print");
		// driver.get("https://www.google.com/");
	 }
	 
	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
		// RemoteWebDriver driver;
		 DesiredCapabilities dc = DesiredCapabilities.chrome();
		  
	//	Proxy proxy = new Proxy();
	//	proxy.setHttpProxy("webproxy.virginmoney.com:8081");
	//	proxy.setSslProxy("webproxy.virginmoney.com:8081");
	//	dc.setCapability("proxy",proxy);

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
	// System.setProperty("webdriver.chrome.driver","/Users/naveenkhunteta/Downloads/chromedriver");
	// driver = new ChromeDriver();
	
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Virgin Money UK - Credit cards, Mortgages, Savings, ISAs, Investments and Insurance", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^Do what I say jaffa$")
	 public void user_enters_username_and_password() throws InterruptedException{
		 driver.findElement(By.xpath("//a[@id='product-nav']/span")).click();
		    driver.findElement(By.xpath("//a[@id='navbarDropdownCurrentaccounts']/div/span")).click();
		    driver.findElement(By.xpath("//ul[@id='navbarNavDropdown']/li/nav/div/ul/li/a/span")).click();
		    driver.findElement(By.xpath("//a[@id='product-nav']/span")).click();
		    driver.findElement(By.xpath("//a[@id='navbarDropdownSavings']/div/span")).click();
		    driver.findElement(By.xpath("//ul[@id='navbarNavDropdown']/li[2]/nav/div/ul/li/a/span")).click();
		    driver.findElement(By.cssSelector("h3.card-title.h3")).click();
		    driver.findElement(By.xpath("//tr[@id='1_year_fixed_rate_cash_e_isa_issue_387']/td/a")).click();
		    Thread.sleep(5000);
		    assertEquals(driver.findElement(By.cssSelector("h1.h1.display-2")).getText(), "1 Year Fixed Rate Cash E‑ISA");
		    driver.findElement(By.linkText("Please read the Summary Box")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.cssSelector("span.accordion__icon")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.cssSelector("span.accordion__icon")).click();
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() throws InterruptedException {
		 driver.findElement(By.linkText("Please read the Summary Box")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.cssSelector("span.accordion__icon")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.cssSelector("span.accordion__icon")).click();
	// JavascriptExecutor js = (JavascriptExecutor)driver;
	// js.executeScript("arguments[0].click();", loginBtn);
	 }
	
	 /* 
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("CRMPRO", title);
	 }
	 
	 @Then("^user moves to new contact page$")
	 public void user_moves_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		
		}
	 
	
	 @Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname, String position){
		 driver.findElement(By.id("first_name")).sendKeys(firstname);
		 driver.findElement(By.id("surname")).sendKeys(lastname);
		 driver.findElement(By.id("company_position")).sendKeys(position);
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	 }*/
	 

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	
	

}
