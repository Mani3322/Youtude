package socialmedia;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement Ele1 = driver.findElement(By.name("search_query"));
		Ele1.sendKeys("Mangali Siva songs Telugu");
		Ele1.submit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement Ele2 = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer[1]/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a"));
		Ele2.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String Currenturl = driver.getCurrentUrl();
		System.out.println("Current URL is: " +Currenturl);
		Clipboard(Currenturl);
		
		driver.quit();
		
		WebDriver driver2 = new ChromeDriver();
		driver2.get(Currenturl);
		System.out.println("Current URL is:" +Currenturl);
		
		
		
		if (Currenturl.equals(driver2.getCurrentUrl())) 
		{
			System.out.println("0");
			
		
		} else 
		{
			System.out.println("1");

		}
		driver2.quit();
	

	}

	private static void Clipboard(String text) 
	{
		
	        StringSelection stringSelection = new StringSelection(text);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
		
	}

	

}
