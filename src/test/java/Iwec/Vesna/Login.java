package Iwec.Vesna;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {

	@Test
	public void TC_LOGIN_003LogInWithValidEmailInvalidPass (){
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//a[@href='/login?returnUrl=%2F']")).click();
		driver.findElement(By.id("Email")).sendKeys("johndoe@email.com");
		driver.findElement(By.id("Password")).sendKeys("123457");
		driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
		
				
		String actualString = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).getText();
		
		
		String expectedString = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";
		
		
		Assert.assertEquals(actualString, expectedString);
		
		driver.quit();
	}
		@Test
		public void TC_LOGIN_007_logInWithValidEmailEmptyPass (){
			
			
			System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			
			
			driver.findElement(By.xpath("//*[@class=\"ico-login\"]")).click();
			driver.findElement(By.id("Email")).sendKeys("johndoe@email.com");
			driver.findElement(By.id("Password")).sendKeys("");
			driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
			
					
			
			String actualString = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).getText();
			
			
			String expectedString = "Login was unsuccessful. Please correct the errors and try again.\n"
					+ "No customer account found";
			
			
			Assert.assertEquals(actualString, expectedString);
			
			driver.quit();
		
		
		
	}
		@Test
		public void TC_LOGIN_008_logInWithEmptyEmailValidPass (){
			
			
			System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			
			
			driver.findElement(By.xpath("//*[@class=\"ico-login\"]")).click();
			driver.findElement(By.name("Email")).sendKeys("");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
			
					
			
			String actualString = driver.findElement(By.xpath("//*[@id=\"Email-error\"]")).getText();
			
			
			String expectedString = "Please enter your email";
			
			
			Assert.assertEquals(actualString, expectedString);
			
			driver.quit();
	
		}
}
