package com.waitElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitElementDisplay {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\a631020\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		Action act = builder.moveToElement(driver.findElement(By.xpath(".//*[@id='userLoginBlock']/a"))).build();
		act.perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='signInBtn']")).click();
		
		driver.navigate().refresh();
		
		WebElement user = driver.findElement(By.xpath("//input[@class='yt-sme-mobile-input required_field email-login-box firepath-matching-node']"));
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(user));
				
		if(user.isDisplayed()) {
			if(user.isEnabled()) {
				user.sendKeys("9895656999");
			}	
		}
		System.out.println("The TextBox is visible");
		
		driver.close();
		
		
	}

}
