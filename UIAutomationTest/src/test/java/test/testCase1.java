package test;
 
import org.testng.annotations.Test;

import Objects.WebLocators;
import testComponents.BaseTest;
import org.testng.Assert;
 
public class testCase1 extends BaseTest{
 
 
	@Test
	public void testWorldPopulation1() {
		long endTime = System.currentTimeMillis() + 20000;
		WebLocators locators = launchapplication();
		while (System.currentTimeMillis() < endTime) {
			
			System.out.println("Current World Population = "+locators.getcurrentWorldPopulation());
			System.out.println("total birth for today  = "+locators.getBirthsToday());
			System.out.println("total Deaths for Today = "+locators.getdeathsToday());
			System.out.println("Population Growth for Today = "+locators.getpopulationGrowthToday());
			System.out.println("total births for this year = "+locators.getbirthsThisYear());
			System.out.println("total deaths for this year= "+locators.getdeathsThisYear());
			System.out.println("Population Growth This Year = "+locators.getpopulationGrowthThisYear());
			System.out.println();
		}
	}
//	@Test
//	public void differenceInPopulationValidation() {
//	WebLocators locators = launchapplication();
//	Long growthtoday = BaseTest.differ(locators.getBirthsToday(), locators.getdeathsToday());
//	
//	Assert.assertequals(growthtoday,Long.parseLong(locators.getpopulationGrowthToday));
//	Assert.assertequals(growthtoday,Long.parseLong(locators.getpopulationGrowthThisYear));

		
//	}
 
	}