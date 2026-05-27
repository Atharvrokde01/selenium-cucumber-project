package loginTest;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

	public static WebDriver driver;

	@Given("Open the Browser")
	public void open_the_browser() {

		driver = new ChromeDriver();

	}

	@When("Open the Homepage of Automation_Exercise Website")
	public void open_the_homepage_of_automation_exercise_website() {

		driver.navigate().to("https://automationexercise.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Then("Verify the logo on Homepage")
	public void verify_the_logo_on_homepage() {

		boolean status = driver
				.findElement(By.xpath("//img[@alt='Website for automation practice']"))
				.isDisplayed();

		Assert.assertEquals(true, status);

	}

	@Then("Close the Browser")
	public void close_the_browser() {

		driver.quit();

	}

}