package ITkumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualTask {

	public static void main(String[] args) throws InterruptedException {
		//Invoke Google Chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Open url 
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(1000);
		
		//login to website 
		WebElement username=driver.findElement(By.cssSelector("#user-name"));
		username.sendKeys("standard_user");
		Thread.sleep(1000);
		WebElement Password=driver.findElement(By.cssSelector("#password"));
		Password.sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		//Wait until the home page gets loaded 
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("#login-button")));
		WebElement login=driver.findElement(By.cssSelector("#login-button"));
		login.click();
		
		// verify the logo on home page.
		WebElement textDemo = driver.findElement(By.cssSelector("div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.primary_header div.header_label:nth-child(2) > div.app_logo"));
		 
		if(textDemo.isDisplayed())
		{
		System.out.println("Element found");
		}
		 
		else {
		System.out.println("Element not found");
		driver.quit();
		}
		
		//Add to cart the product
		WebElement ADDCart1= driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
		ADDCart1.click();
		
		//view cart
		WebElement Viewcart= driver.findElement(By.cssSelector("div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.primary_header div.shopping_cart_container:nth-child(3) > a.shopping_cart_link"));
		Viewcart.click();
		Thread.sleep(3000);
		WebElement CheckOut= driver.findElement(By.cssSelector("#checkout"));
		CheckOut.click();
		
		//before order placed
		WebElement firstname=driver.findElement(By.cssSelector("#first-name"));
		firstname.sendKeys("kumar");
		Thread.sleep(1000);
		WebElement lastname=driver.findElement(By.cssSelector("#last-name"));
		lastname.sendKeys("indira");
		Thread.sleep(1000);
		WebElement pincode=driver.findElement(By.cssSelector("#postal-code"));
		pincode.sendKeys("123456");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
		WebElement Continue=driver.findElement(By.cssSelector("#continue"));
		js.executeScript("arguments[0].scrollIntoView();", Continue);
		Thread.sleep(3000);
		Continue.click();
		Thread.sleep(2000);
		
		//order confirmation
		WebElement Finish=driver.findElement(By.cssSelector("#finish"));
		js.executeScript("arguments[0].scrollIntoView();", Finish);
		Finish.click();
		Thread.sleep(3000);
		
		//After order placed
		WebElement Backtohome=driver.findElement(By.cssSelector("#back-to-products"));
		Thread.sleep(3000);
		Backtohome.click();
		
		//Logout
		WebElement Menubar=driver.findElement(By.cssSelector("#react-burger-menu-btn"));
		Menubar.click();
		WebElement logout=driver.findElement(By.cssSelector("#logout_sidebar_link"));
		logout.click();
		Thread.sleep(2000);
		
		//Close the browser
		driver.quit();
	}

}
