package GTAqua;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {
	
	
	static WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
	//Check if parameter passed from TestNG is 'firefox'
	if(browser.equalsIgnoreCase("firefox")){
	//create firefox instance
	//System.setProperty("webdriver.gecko.driver","C:/Users/sanjayp/eclipse-workspace-PicnicSelenium/SeleniumProject/drivers/geckodriver.exe");
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
	 
	//Check if parameter passed as 'chrome'
	else if (browser.equalsIgnoreCase("chrome")){
	//set path to chromedriver.exe
	//System.setProperty("webdriver.chrome.driver","C:/Users/sanjayp/eclipse-workspace-PicnicSelenium/SeleniumProject/drivers/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	 
	}

	else{
	//If no browser passed throw exception
	throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public static void main(String[] args) throws InterruptedException, IOException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		Deletefile();
		driver.get("https://blazedemo.com/login");
		Thread.sleep(3000);
		String Mainpage="MP";
		Screenshot(Mainpage);
		WebElement Register=driver.findElement(By.linkText("Register"));
		Register.click();
		Thread.sleep(3000);
		WebElement Name=driver.findElement(By.name("name"));
		Name.sendKeys("Kumar");
		Thread.sleep(2000);
		WebElement Company=driver.findElement(By.cssSelector("#company"));
		Company.sendKeys("Rookie Sep21 -Aqua");
		Thread.sleep(2000);
		WebElement Email=driver.findElement(By.cssSelector("#email"));
		Email.sendKeys("indirakumar1797@gmail.com");
		Thread.sleep(2000);
		WebElement Password=driver.findElement(By.cssSelector("#password"));
		Password.sendKeys("kumar");
		Thread.sleep(2000);
		WebElement ConfirmPW=driver.findElement(By.cssSelector("#password-confirm"));
		ConfirmPW.sendKeys("kumar");
		String Final="F";
		Screenshot(Final);
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	public static void Screenshot(String name) throws IOException 
	
	{ 
	
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	
	FileUtils.copyFile(src, new File("C:\\Users\\indirakm\\Pictures\\sample\\"+name+".png")); 
	
	} 
	
	public static void Deletefile() {
	File path = new File("C:\\Users\\indirakm\\Pictures\\sample\\");
	File[] files = path.listFiles();
	for (File file : files) {
	    System.out.println("Deleted filename :"+ file.getName());
	    file.delete();
	}
}

}
