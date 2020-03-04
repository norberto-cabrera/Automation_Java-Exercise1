import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OpenAppleWebPage {

	public static void main(String[] args) {
		// declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
        String baseUrl = "https://www.apple.com/mx/";
        String expectedText = "Esta es nuestra línea más poderosa hasta ahora: MacBook Pro, Mac Pro y Pro Display XDR. Y está lista para ayudarte a hacer tu mejor trabajo.";
        String expectedTitle = "iPhone 11 - Apple (MX)";
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
        driver.findElement(By.xpath("//*[@class='ac-gn-searchform-input']")).sendKeys("iPhone 11");
        driver.findElement(By.xpath("//*[@class='ac-gn-searchform-input']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@data-relatedlink='2']")).click();
        
        // get the actual value of the title and compare with the expected Title
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        
        // Validate is these elements are enabled
        // Descripcion
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='ac-ln-menu-link current']")).isEnabled(), expectedboolean);
        //Especificaciones
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='ac-ln-menu-link']")).isEnabled(), expectedboolean);
        //Comprar
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='ac-ln-button']")).isEnabled(), expectedboolean);
        

        //close Fire fox
        driver.close();
       
    


	}

}

