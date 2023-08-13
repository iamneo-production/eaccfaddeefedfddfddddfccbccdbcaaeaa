package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AppTest {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
		
	}
   @Test
   public void testcase_1() throws InterruptedException
   {
	driver.get("http://jqueryui.com/droppable/");`
	String actualTitle = driver.getTitle();
	String expectedTitle = "Droppable | jQuery UI";
	Assert.assertEquals(actualTitle, expectedTitle);

   }
	@Test
	public void testcase_2() throws InterruptedException 
      {
	       //write Your Code here to Login
               
		   driver.switchTo().frame(0);
		   WebElement droppable = driver.findElement(By.id("droppable"));
		   String actualText = droppable.getText();
		   String expectedText = "Dropped!";
		   Assert.assertEquals(actualText, expectedText, "Text is not as expected");
	}
@Test
	public void testcase_3() throws InterruptedException 
      {
	       //write Your Code here to Login
		   driver.switchTo().frame(0);
		   WebElement droppable = driver.findElement(By.id("droppable"));
		   Actions actions = new Actions(driver);
		   actions.dragAndDrop(driver.findElement(By.id("draggable")), droppable).perform();
		   String actualColor = droppable.getCssValue("background-color");
		   String expectedColor = "rgba(255, 255, 0, 1)";
		   Assert.assertEquals(actualColor, expectedColor, "Color is not as expected");
		
	}

		
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}