package com.reg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
		driver.manage().deleteAllCookies();
		
		String email ="regggoutss@out.co";
		String password ="Test@1234";
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys(password);	
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
		
		String login_msg = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in']")).getText();

		if (login_msg.equals("Welcome, Alpha Beta!")) {
			System.out.println("Login succesfull");
		}
		else {
			System.out.println("Login fail");
		}
		
		
		Thread.sleep(4000);
		driver.close();
	}

}
