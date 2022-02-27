package TESTNG_CHAPTER;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot_Handle1 
{     
       public static void main(String[] args) throws InterruptedException, IOException 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\JYOTI\\OneDrive\\Desktop\\Books\\Browser driver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
	 
    driver.get("https://www.ebay.com/");
    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
	FileUtils.copyFile(src,new File("C:\\Users\\JYOTI\\eclipse-workspace\\Selenium\\Screenshot_selenium\screen.jpg"));
	System.out.println("The screenshot is Taken");
	driver.quit();
}}






