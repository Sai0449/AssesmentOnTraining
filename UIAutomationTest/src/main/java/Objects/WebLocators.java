package Objects;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
 
public class WebLocators{
	
	WebDriver driver;
	
	public WebLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//span[@rel='current_population']")
	WebElement currentWorldPopulation;
	
	@FindBy(xpath = "//span[@rel='births_today']")
	WebElement birthsToday;
	
	@FindBy(xpath = "//span[@rel='dth1s_today']")
	WebElement deathsToday;
	
	@FindBy(xpath = "//span[@rel='absolute_growth']")
	WebElement populationGrowthToday;
	
	@FindBy(xpath = "//span[@rel='births_this_year']")
	WebElement birthsThisYear;
	
	@FindBy(xpath = "//span[@rel='dth1s_this_year']")
	WebElement deathsThisYear;
	
	@FindBy(xpath = "//span[@rel='absolute_growth_year']")
	WebElement populationGrowthThisYear;
	
	
	public String getcurrentWorldPopulation() {
		return currentWorldPopulation.getText();
	
	}
	
	public String getBirthsToday() {
		return birthsToday.getText();
	
	}
	
	public String getdeathsToday() {
		return deathsToday.getText();
	
	}
	
	public String getpopulationGrowthToday() {
		return populationGrowthToday.getText();
	
	}
	
	public String getbirthsThisYear() {
		return birthsThisYear.getText();
	
	}
	
	public String getdeathsThisYear() {
		return deathsThisYear.getText();
	
	}
	
	public String getpopulationGrowthThisYear() {
		return populationGrowthThisYear.getText();
	
	}
	
	
	
	
}