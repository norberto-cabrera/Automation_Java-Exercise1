package TestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNg {
	
	private WebDriver driver; 
  @Test
  public void VerifyApplePage() {
	  String baseUrl = "https://www.apple.com/mx/";
      String expectedText = "Esta es nuestra l�nea m�s poderosa hasta ahora: MacBook Pro, Mac Pro y Pro Display XDR. Y est� lista para ayudarte a hacer tu mejor trabajo.";
      String expectedTitle = "iPhone XR - Apple (MX)";
      boolean expectedboolean = true;

      // launch Chrome and direct it to the Base URL
      driver.get(baseUrl);
      
      // Go to Mac by finding and clicking the element
      driver.findElement(By.xpath("//*[@class='ac-gn-link ac-gn-link-mac']")).click();
      
      // Validate Text using Assert
      //Assert.assertEquals(driver.findElement(By.xpath("//*[@class='hero-headline typography-headline-super']")).getText(), expectedText);
      Assert.assertEquals(driver.findElement(By.xpath("//*[@class='hero-copy typography-eyebrow-elevated']")).getText(), expectedText);

      // Click on Search Bar, Search for iPhone XR, send Enter key and select the finding.
      driver.findElement(By.xpath("//*[@class='ac-gn-link ac-gn-link-search']")).click();
      driver.findElement(By.xpath("//*[@class='ac-gn-searchform-input']")).sendKeys("iPhone XR");
      driver.findElement(By.xpath("//*[@class='ac-gn-searchform-input']")).sendKeys(Keys.ENTER);
      driver.findElement(By.xpath("//*[@data-relatedlink='2']")).click();
      
      // get the actual value of the title and compare with the expected Title
      Assert.assertEquals(driver.getTitle(), expectedTitle);
      
      // Validate is these elements are enabled
      //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ac-localnav']/div/div[2]/div[2]/div[2]/div[2]/a")).isEnabled(), expectedboolean);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
