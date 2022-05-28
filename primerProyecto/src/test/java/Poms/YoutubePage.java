package Poms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubePage {
	
	WebDriver driver;
	//Locators
	private String searchBox= "//input[@name = 'search_query']";//Elemento Buscador Youtube
	private String videoLocator= "//div[@id='title-wrapper']";//Elemento Título Video Click
	private String titleSong="//*[@id=\"container\"]/h1";//Elemento Título Salida Consola
			
	public YoutubePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean writeSearchBox(String searchValue) {
		boolean flag = false;
		try {
			WebElement inputText = driver.findElement(By.xpath(searchBox));
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
	
	public boolean clickVideo() { 
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(videoLocator));//El primer resultado de la búsqueda
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();			
		}

		return flag;
	}
	
	public boolean returnTitleVideo() { 
		boolean flag = false;
		try {
			WebElement nameText = driver.findElement(By.xpath(titleSong));
			System.out.println("Tittle Song: " + nameText.getText());
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();			
		}

		return flag;
	}
	
	}


