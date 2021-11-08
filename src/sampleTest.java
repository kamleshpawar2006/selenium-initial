import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class sampleTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
            wait.until(presenceOfElementLocated(By.id("login_field")));
            System.out.println("login field found");
        } catch(Exception e) {
        	System.out.println("login field not found");
            driver.quit();
        }

		WebElement username = driver.findElement(By.id("login_field"));
		WebElement password = driver.findElement(By.id("password"));

		username.sendKeys("useremail@gmail.com");
		password.sendKeys("1234556");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		try {
            wait.until(presenceOfElementLocated(By.id("js-flash-container")));
            System.out.println("found error message");
        } catch(Exception e) {
        	System.out.println("error message not found");
            driver.quit();
        }
		
//		testNg
//		Assert.assertEquals(expectedUrl,actualUrl);
		 
	}
}
