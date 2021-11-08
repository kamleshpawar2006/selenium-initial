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
		driver.get("https://www.freelancer.com/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
            wait.until(presenceOfElementLocated(By.className("CheckboxLabel")));
            System.out.println("found");
        } catch(Exception e) {
        	System.out.println("not found");
            driver.quit();
        }

		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

		username.sendKeys("akmlesh@gmail.com");
		password.sendKeys("kamlesh");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
	}
}
