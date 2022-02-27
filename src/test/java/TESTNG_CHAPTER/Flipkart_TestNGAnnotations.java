package TESTNG_CHAPTER;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

public class Flipkart_TestNGAnnotations
{       
	  WebDriver driver;	
      @BeforeSuite
      public void OpenBrowser()
      {
	      System.out.println("Open Browser");
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\JYOTI\\OneDrive\\Desktop\\Books\\Browser driver\\chromedriver.exe");
	      driver = new ChromeDriver();
      }
      @BeforeTest
      public void openURL()
      {
    	  System.out.println("Enter URL");
    	  driver.get("https://www.flipkart.com/");
      }
      @BeforeClass
      public void MaximiseURL()
      {
    	  System.out.println("Maximise the URL");
    	  driver.manage().window().maximize();
      }
      @BeforeMethod
      public void GetCookies()
      {
    	  System.out.println("Get cookies");
      }
      @Test
      public void Login() throws InterruptedException
      {
    	  System.out.println("Login to site");
    	  Actions a =new Actions(driver);
    	  a.moveToElement(driver.findElement(By.xpath("//div[@class='_2Xfa2_']"))).build().perform();
    	  Thread.sleep(2000);
    	  driver.navigate().to("https://www.mca.gov.in/content/mca/global/en/home.html");
    	  Thread.sleep(2000);
    	  driver.navigate().back();
    	  Thread.sleep(2000);
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
     @Test
      public void AccessLogin() throws InterruptedException
      {
    	  System.out.println("Access Login");
    	  driver.get("https://www.mercurytravels.co.in/international-holidays");
    	  driver.manage().window().maximize();
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
    	 
      }
      @AfterMethod
      public void GetScreenshot() throws IOException
      {
    	  System.out.println("Get Screenshot Of Page");
    	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
    	  FileUtils.copyFile(src,new File("C:\\Users\\JYOTI\\eclipse-workspace\\Selenium\\Screenshot_selenium\\screen.jpg"));
    	  System.out.println("Screenshot is taken");
      }
      @AfterClass
      public void DeleteCookies()
      {
    	  System.out.println("Delete Cookies");
      }
      @AfterTest
      public void dbconnectionbased()
      {
    		System.out.println("db connection closed");
  	  }
  	
  	  @AfterSuite
  	  public void close()
    	{
  		     System.out.println("close the browser");
  		     driver.close();
        }
}
