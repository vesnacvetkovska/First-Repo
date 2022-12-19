package Iwec.Vesna;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;


public class Register {
	@Test
	public void TC_REGISTER_002_registerWithValidCredentials (){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//*[@href='/register?returnUrl=%2F']")).click();
		
		driver.findElement(By.id("FirstName")).sendKeys("Jane");
		driver.findElement(By.id("LastName")).sendKeys("Doe");
		driver.findElement(By.id("Email")).sendKeys("janedoe@email.com");
		driver.findElement(By.name("Company")).sendKeys("CompannyNo1");
		driver.findElement(By.name("Password")).sendKeys("123456");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.name("register-button")).click();
		
		String expectedUrl = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
		String actUrl = driver.getCurrentUrl();
		
		
		Assert.assertEquals(actUrl, expectedUrl);
		
		driver.quit();
		
	}

	@Test
			public void TC_REGISTER_005_regWithDifferentPassAndCofirmPass() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//*[@href='/register?returnUrl=%2F']")).click();
		
		driver.findElement(By.xpath("//*[@name=\"FirstName\"]")).sendKeys("Tim");
		driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Kim");
		driver.findElement(By.id("Email")).sendKeys("timkim@email.com");
		driver.findElement(By.name("Company")).sendKeys("CompannyNo1");
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("123456");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("223456");
		driver.findElement(By.name("register-button")).click();
		
		
		
		
			
		String actualString = driver.findElement(By.id("ConfirmPassword-error")).getText();
		
		
		String expectedString = "The password and confirmation password do not match.";
		
		
		Assert.assertEquals(actualString, expectedString);
				driver.quit();
					
	}

	@Test
	
		public void TC_REGISTER_009_registerWithInvalidPass() {
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://demo.nopcommerce.com/");
	driver.findElement(By.xpath("//*[@href='/register?returnUrl=%2F']")).click();
	driver.manage().window().maximize();

	driver.findElement(By.xpath("//*[@name=\"FirstName\"]")).sendKeys("Tim");
	driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Kim");
	driver.findElement(By.id("Email")).sendKeys("timkim@email.com");
	driver.findElement(By.name("Company")).sendKeys("CompannyNo1");
	driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("12345");
	driver.findElement(By.name("ConfirmPassword")).sendKeys("12345");
	driver.findElement(By.name("register-button")).click();
	
	
	String actualString = driver.findElement(By.id("Password-error")).getText();
			
	String expectedString = "Password must meet the following rules:\n" + "must have at least 6 characters";
		
	Assert.assertEquals(actualString, expectedString);
			driver.quit();
			
	
}
	@Test
	
			public void TC_REGISTER_011_registerWithEmptyFirstNameField() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.className("ico-register")).click();
		driver.manage().window().maximize();

		driver.findElement(By.id("FirstName")).sendKeys("Tim");
		driver.findElement(By.name("LastName")).sendKeys("");
		driver.findElement(By.id("Email")).sendKeys("timkim@email.com");
		driver.findElement(By.id("Company")).sendKeys("CompannyNo1");
		driver.findElement(By.name("Password")).sendKeys("123456");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@name=\"register-button\"]")).click();
		
		
		String actualString = driver.findElement(By.id("LastName-error")).getText();
				
		String expectedString = "Last name is required.";
				
		Assert.assertEquals(actualString, expectedString);
		driver.quit();
		
		
	}
}
