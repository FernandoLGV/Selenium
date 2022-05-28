package Tests;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;
import Poms.YoutubePage;

public class WindowManager {
	private WebDriver driver;
	private GooglePage google;
    private YoutubePage youtubePage;
    
	
	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
		driver = new ChromeDriver();
		
		//MODO HEADLESS
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");		
		driver = new ChromeDriver(options);*/		
	}

	@Test
	public void test() throws InterruptedException{
		
		// Goes to page	
		google = new GooglePage(driver);
		youtubePage = new YoutubePage(driver);
		driver.get("http://google.com");
		google.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Search for desire item
		assertTrue(google.writeSearch("Youtube"));
		//Clicks first result
		assertTrue(google.clickYoutubePage());
		//Song to be search
		assertTrue(youtubePage.writeSearchBox("never gonna give"));
		//Interaction Title Video
		assertTrue(youtubePage.clickVideo());
		Thread.sleep(11000);
		//Print Song Title
		assertTrue(youtubePage.returnTitleVideo());
		Thread.sleep(10000);				
		}

	@After
	public void teardown() {		
		driver.quit();		
	}
}
