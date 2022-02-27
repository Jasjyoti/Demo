package TESTNG_CHAPTER;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basic_ProgramTestNG 
{
	WebDriver driver;
	
	@BeforeSuite
	public void openbrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JYOTI\\OneDrive\\Desktop\\Books\\Browser driver\\chromedriver.exe");
		 driver= new ChromeDriver();
	}
	
	@BeforeTest
	public void enterURL()
	{
		System.out.println("enter url");
		driver.get("https://www.mercurytravels.co.in/");
	}
	
	@BeforeClass()
	public void maxbrowser()
	{
		System.out.println("maximize browser");	
		driver.manage().window().maximize();
	}
	
	@BeforeMethod()
	public void getcookies()
	{
		System.out.println("get cookies");
	}
	
	@Test(priority = 2)
	public void login() throws InterruptedException
	{
		System.out.println("login");
		  Thread.sleep(3);
		  Actions a =new Actions(driver);
		  a.moveToElement(driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/a"))).build().perform();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//a[contains(text(),'User Login')])[2]")).click ();
		  Thread.sleep(2000);
		  driver.findElement(By.id("sign_user_email")).sendKeys("sonawanesushil57@gmail.com");
		 Thread.sleep(2000);
		 driver.findElement(By.id("sign_user_password")).sendKeys("Sushil@123");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//button[@class='btn btn-lg btn-primary modal-btn ajax-submit'])[1]")).click();
		 Thread.sleep(2000);
		 WebElement welcomeUser=driver.findElement(By.xpath("(//span[@class='caret'])[6]"));
		 Actions action = new Actions(driver);
	     action.moveToElement(welcomeUser).build().perform();
	     Thread.sleep(2000);
	     WebElement logout=driver.findElement(By.xpath("(//a[text()=' Log Out'])[2]"));
	     logout.click();
		
	}
	@Test(enabled=false)
	public void Enable()
	{
		System.out.println("Enable Apply");
		driver.get("https://twitter.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("class=\"nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb oXtfBe-l4eHX\"")).sendKeys("Bobadejyoti5@gmail.com");
		
	}
	@Test(priority = 1)
	public void webpage() throws InterruptedException
	{
		System.out.println("Webpage");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		  Actions b =new Actions(driver);
    	  b.moveToElement(driver.findElement(By.xpath("//div[@class='_2Xfa2_']"))).build().perform();
    	  driver.findElement(By.xpath("//div[@class='go_DOp _2errNR']/div/div/div/a"));
  		  Thread.sleep(2000);
  		  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("8788152589");
  	   	  Thread.sleep(2000);
  		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("jyoti");
  		  Thread.sleep(2000);
  		  driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();	
  		  Thread.sleep(2000);   
	}
	
	@AfterMethod
	public void getscreenshot()
	{
		System.out.println("get ss");
	}
	
	@AfterClass
	public void deletecookies()
	{
	System.out.println("delete cookies");	
	}
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("db connection closed");
	}
	
	@AfterSuite
	public void close()
	{
		System.out.println("close the broser");
		driver.close();
	}
	
}
