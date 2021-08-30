package StepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks {
	
	@Before
	public void beforeScenario(Scenario scenario) {		
		System.out.println("Started execution for the scenario : " + scenario.getName());
	}
	
	
	@After
	public void AfterScenario(Scenario scenario) {
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}

}
