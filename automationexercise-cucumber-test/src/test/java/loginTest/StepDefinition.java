package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;
	@Given("Open browser {string}")
	public WebDriver open_browser(String browser) {
	  if ("chrome".equalsIgnoreCase(browser)) {
		  driver= new ChromeDriver();
		
	}
	  else if ("edge".equalsIgnoreCase(browser)) {
		  driver= new EdgeDriver();
		
	}
	  else if ("firefox".equalsIgnoreCase(browser)) {
		  driver=new FirefoxDriver();
		
	} 
	  else {
		System.out.println("Wrong Input!");
	}
		System.out.println("Browser Open!");
	return driver;
	}

	@And("Navigate to Website URL {string}")
	public void navigate_to_website_url(String URL) {
	   driver.navigate().to(URL);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Click Login")
	public void click_login() {
	   driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	}

	@Then("Enter EmailId {string} and Password {string}")
	public void enter_email_id_and_password(String email, String pass) {
	    driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}


	@And("Verify {string} is visible")
	public void verify_is_visible(String text) {
		String expected_text= text;
		String actual_text= driver.findElement(By.xpath("//li[10]//a[1]")).getText();
		if (actual_text.equalsIgnoreCase(actual_text)) {
			System.out.println("Login Verify");
			
		}
		else {
			System.out.println("Login Not Verify");
		}
	}




}
