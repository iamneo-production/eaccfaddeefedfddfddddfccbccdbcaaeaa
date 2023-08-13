import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumAssignment {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver and open the browser
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void performDragAndDrop() {
        // Open the website
        driver.get("http://jqueryui.com/droppable/");
        
        // Switch to the iframe containing the drag and drop elements
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        // Locate source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Perform drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Verify color property of CSS
        String targetBackgroundColor = targetElement.getCssValue("background-color");
        Assert.assertEquals(targetBackgroundColor, "rgba(70, 130, 180, 1)", "Color property doesn't match.");

        // Verify text change
        String targetText = targetElement.getText();
        Assert.assertEquals(targetText, "Dropped!", "Text change verification failed.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
