package Poms;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	//Locators
	private String inputTextLoc = "//input[@name = 'q']";//Buscador Google Enter
	public WebDriver driver;
	private String pageLoc = "//h3[text()='YouTube']";//Elemento en lista de búsqueda 
		
	public GooglePage(WebDriver driver) {
		super();
		this.driver = driver;       
	}
	
	public boolean writeSearch(String searchValue) {
		boolean flag = false;
		try {
			//Búsqueda elemento: Xpath(node"//",tagname,attributes"@",attributes name, value of attribute'valor')
			WebElement inputText = driver.findElement(By.xpath(inputTextLoc));
			inputText.sendKeys(searchValue);                                   
			inputText.sendKeys(Keys.ENTER);
			flag = true;		
		}
	    catch(Exception e) {
	    	System.out.println("Something went wrong: (");
	    	e.printStackTrace();
	    }
		return flag;
	}

	public boolean clickYoutubePage() { 
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(pageLoc));//El primer resultado de la búsqueda
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

}
