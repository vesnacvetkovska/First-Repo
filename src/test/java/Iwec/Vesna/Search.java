package Iwec.Vesna;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search {
	@Test
	public void TC_SEARCH_001_searchForexistingPrudct () {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		String item = "nIke";
		
		
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.name("q")).sendKeys(item);
		
		driver.findElement(By.xpath("//*[@class='button-1 search-box-button']")).click();

		int size = driver.findElements(By.xpath("//h2[@class=\"product-title\"]")).size();
		
		for(int i = 1; i < size + 1; i++) {
			
			String text = driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" +i+ "]")).getText();
			
					
			assertTrue((text.toLowerCase().contains(item.toLowerCase())), "Error: item " + item + " is not available in the results");
			
		}
	}
	@Test
	public void TC_SEARCH_002_searchForNonExistingProduct () {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.name("q")).sendKeys("Sony");
		driver.findElement(By.xpath("//*[@class='button-1 search-box-button']")).click();
		
		String expected = "No products were found that matched your criteria.";
		String acctual = "No products were found that matched your criteria.";
		
		Assert.assertEquals(acctual, expected);

		driver.quit();
		
	}
	@Test
	
		public void TC_SEARCH_004_testIsSearchWorksWithLessThan3characters () {
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.name("q")).sendKeys("HP");
		driver.findElement(By.xpath("//*[@class='button-1 search-box-button']")).click();
		
		String expected = "Search term minimum length is 3 characters";
		String acctual = "Search term minimum length is 3 characters";
		
		
		Assert.assertEquals(acctual, expected);
		driver.quit();
		
		
		}
}
