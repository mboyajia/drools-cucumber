package drools.cucumber;

import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("restriction")
public class HelloCukesStepDefs {
	//this object can be used across all tests in this specific step def class
	DroolsCucumberTest dct = new DroolsCucumberTest();
		
	@Given("^I have a HelloCukes object with id of (\\d+) and myString value of '(.*?)'$")
	public void i_have_a_HelloCukes_object_with_id_of_and_myString_value_of_leet(int id, String myString) throws Throwable {
		assertNotNull(id);
		assertNotNull(myString);
		
	    HelloCukes hc = new HelloCukes(id);
	    hc.setMyString(myString);
	    
	    dct.getFacts().add(hc);
	}

	@When("^I run the rules$")
	public void i_run_the_rules() throws Throwable {
	    dct.runCukesRules(dct.getFacts());
	}
	
	@When("^I run the rules via the BPMN process$")
	public void i_run_the_rules_via_the_BPMN_process() throws Throwable {
	    dct.runCukesRulesProcess(dct.getFacts());
	}

	@Then("^the HelloCukes object with id (\\d+) will have myInteger value of (\\d+)$")
	public void the_HelloCukes_object_with_id_will_have_myInteger_value_of(int id, int myInteger) throws Throwable {
		assertNotNull(id);
		assertNotNull(myInteger);
		Integer actual = new Integer(-1);
		
	    for(Object fact : dct.getFacts()) {
	    	if(fact instanceof HelloCukes) {
	    		if(((HelloCukes) fact).getId().equals(id)) {
	    			actual = ((HelloCukes) fact).getMyInteger();
	    		}
	    	}
	    }
	    
	    assertTrue(myInteger == actual);
	}
}
