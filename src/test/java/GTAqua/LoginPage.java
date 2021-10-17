package GTAqua;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
//	
    WebDriver driver; 
//	@BeforeTest
//	@Parameters("browser")
//	public void setup(String browser) throws Exception{
//	//Check if parameter passed from TestNG is 'firefox'
//	if(browser.equalsIgnoreCase("firefox")){
//	//create firefox instance
//	//System.setProperty("webdriver.gecko.driver","C:/Users/sanjayp/eclipse-workspace-PicnicSelenium/SeleniumProject/drivers/geckodriver.exe");
//	WebDriverManager.firefoxdriver().setup();
//	driver = new FirefoxDriver();
//	driver.manage().window().maximize(); 
//	}
//	 
//	//Check if parameter passed as 'chrome'
//	else if (browser.equalsIgnoreCase("chrome")){
//	//set path to chromedriver.exe
//	//System.setProperty("webdriver.chrome.driver","C:/Users/sanjayp/eclipse-workspace-PicnicSelenium/SeleniumProject/drivers/chromedriver.exe");
//	WebDriverManager.chromedriver().setup();
//	driver = new ChromeDriver();
//	driver.manage().window().maximize(); 
//	}
//
//	else{
//	//If no browser passed throw exception
//	throw new Exception("Browser is not correct");
//	}
//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//	}

	//public static void main(String[] args) throws InterruptedException {
		@BeforeTest
		public void Home() throws InterruptedException, IOException {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		login();
	}
		
			@Test
		public void login() throws InterruptedException, IOException{
			//Deletefile();
			driver.get("https://adactinhotelapp.com/");
			Thread.sleep(1000);
			WebElement username=driver.findElement(By.id("username"));
			username.sendKeys("kumarindira");
			Thread.sleep(1000);
			WebElement Password=driver.findElement(By.name("password"));
			Password.sendKeys("PHebZZsmrKi2@BB");
			Thread.sleep(1000);
			//String First="Login";
			//Screenshot(First);
			WebElement login=driver.findElement(By.className("login_button"));
			login.click();
			Thread.sleep(1000);
			SearchHotel();
		
	}
		
		public void SearchHotel() throws InterruptedException, IOException  {
			WebElement location= driver.findElement(By.id("location"));
			Select country=new Select(location);
			country.selectByIndex(3);
			Thread.sleep(1000);
			WebElement hotels= driver.findElement(By.name("hotels"));
			Select hotelname=new Select(hotels);
			hotelname.selectByIndex(2);
			Thread.sleep(1000);
			WebElement roomtype= driver.findElement(By.id("room_type"));
			Select room=new Select(roomtype);
			room.selectByIndex(3);
			Thread.sleep(1000);
			WebElement count= driver.findElement(By.name("room_nos"));
			Select nocount=new Select(count);
			nocount.selectByIndex(2);
			Thread.sleep(1000);
			WebElement Adults= driver.findElement(By.id("adult_room"));
			Select adultscount=new Select(Adults);
			adultscount.selectByIndex(3);
			Thread.sleep(1000);
			WebElement children= driver.findElement(By.name("child_room"));
			Select childcount=new Select(children);
			childcount.selectByIndex(3);
			Thread.sleep(1000);
			//String Second="Search";
			//Screenshot(Second);
			WebElement Searchbtn=driver.findElement(By.className("reg_button"));
			Searchbtn.click();
			Thread.sleep(1000);
			SelectHotel();
		}
		
		public void SelectHotel() throws InterruptedException, IOException  {
			WebElement radio1 = driver.findElement(By.name("radiobutton_0"));
			radio1.click();
			Thread.sleep(1000);
			//String Third="SelectHotel";
			//Screenshot(Third);
			WebElement Continue=driver.findElement(By.id("continue"));
			Continue.click();
			Thread.sleep(1000);
			BookHotel();
		}
		
		public void BookHotel() throws InterruptedException, IOException{
			WebElement Fname= driver.findElement(By.cssSelector("#first_name"));
			Fname.sendKeys("Indirakumar");
			Thread.sleep(1000);
			WebElement Lname= driver.findElement(By.cssSelector("#last_name"));
			Lname.sendKeys("Muniswaran");
			Thread.sleep(1000); 
			WebElement address= driver.findElement(By.cssSelector("#address"));
			address.sendKeys("chennai");
			Thread.sleep(1000);
			WebElement CC= driver.findElement(By.cssSelector("#cc_num"));
			CC.sendKeys("1234567890123456");
			Thread.sleep(1000);
			WebElement CCtype= driver.findElement(By.cssSelector("#cc_type"));
			Select type=new Select(CCtype);
			type.selectByIndex(4);
			Thread.sleep(1000);
			WebElement Expirymonth= driver.findElement(By.cssSelector("#cc_exp_month"));
			Select Month=new Select(Expirymonth);
			Month.selectByIndex(1);
			Thread.sleep(1000);
			WebElement Expiryyear= driver.findElement(By.cssSelector("#cc_exp_year"));
			Select Year=new Select(Expiryyear);
			Year.selectByIndex(4);
			Thread.sleep(1000);
			WebElement CVV= driver.findElement(By.cssSelector("#cc_cvv"));
			CVV.sendKeys("123");
			Thread.sleep(1000);
			//String Four="BookHotel";
			//Screenshot(Four);
			WebElement booknow=driver.findElement(By.cssSelector("#book_now"));
			booknow.click();
			Thread.sleep(5000);
			BookingConfirmation();
		}
		
		public void BookingConfirmation() throws InterruptedException, IOException  {
			WebElement confirm=driver.findElement(By.cssSelector("#my_itinerary"));
			confirm.click();
			Thread.sleep(3000);
			BookedItinerary();
		}
		
		public void BookedItinerary() throws InterruptedException, IOException {
			WebElement radio2 = driver.findElement(By.cssSelector("table.content:nth-child(2) table.login table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) td:nth-child(1) > input:nth-child(1)"));
			radio2.click();
			Thread.sleep(1000);
			WebElement Cancelbooking=driver.findElement(By.cssSelector("table.content:nth-child(2) table.login tbody:nth-child(1) tr:nth-child(3) td:nth-child(1) > input.reg_button:nth-child(1)"));
			Cancelbooking.click();
			Alert Cancel = driver.switchTo().alert();
			Thread.sleep(2000);
			Cancel.accept();
			//String Five="Alert";
			//Screenshot(Five);
			Thread.sleep(5000);
			close();
		}
		
//		public void Screenshot(String name) throws IOException { 
//		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
//		FileUtils.copyFile(src, new File("C:\\Users\\indirakm\\Pictures\\GT SS\\"+name+".png")); 
//		} 
//		
//		public static void Deletefile() {
//			File path = new File("C:\\Users\\indirakm\\Pictures\\GT SS\\");
//			File[] files = path.listFiles();
//			for (File file : files) {
//			    System.out.println("Deleted filename :"+ file.getName());
//			    file.delete();
//			}
//		}
		
		@AfterTest
		public void close() {
			driver.quit();
		}
	
}
