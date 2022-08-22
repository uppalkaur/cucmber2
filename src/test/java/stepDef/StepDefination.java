package stepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	WebDriver driver;
	@Given("open url {string}")
	public void open_url(String string) {
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(string);
	    
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("abccc@gmail.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("password")).sendKeys("demotest");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on sign in button")
	public void click_on_sign_in_button() {
		 driver.findElement(By.xpath("/html/body/form/input[3]")).click();
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
		String actual= driver.getCurrentUrl();
		   Assert.assertEquals("https://example.com/", actual);
	}
}
