package registeration_page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class register {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		driver.manage().deleteAllCookies();
		
		String email ="regggoutss@out.co";
		String password ="Test@1234";

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Alpha");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Beta");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		
		//explicit wait only if encounter error 
		
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable
//		 (By.xpath("//button[@title='Create an Account']")));
//	     createAccountButton.click();
		
		Thread.sleep(2000);
		
		String reg_msg = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();

		if (reg_msg.equals("Thank you for registering with Main Website Store.")) {
			System.out.println("Registration succesfull");
		}
		else {
			System.out.println("Registration fail");
		}
		
		driver.close();
	}

}
