package testComponents;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
 
import Objects.WebLocators;
 
public class BaseTest {
	public WebDriver driver;
	public WebLocators Weblocators;
	
	
	@BeforeClass
	public WebDriver initialization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
 
	public WebLocators launchapplication() {
		driver = initialization();
		Weblocators = new WebLocators(driver);
		driver.get("https://www.worldometers.info/world-population/");
		return Weblocators;
		
		
	}
	public static Long differ(String birth,String death) {
		long ActualGrowth = Long.parseLong(birth) - Long.parseLong(death);
		return ActualGrowth;
	}
 
}