package drools.cucumber;

import java.util.ArrayList;
import java.util.Collection;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsCucumberTest {
	private ArrayList<Object> facts;
	
	public DroolsCucumberTest() {
		this.facts = new ArrayList<Object>();
	}
	
	public void runCukesRules(Collection<Object> facts) {
		try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // iterate over facts and insert them individually
        	for(Object fact : facts) {
        		System.out.println(fact);
        		kSession.insert(fact);
        	}
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}
	
	public void runCukesRulesProcess(Collection<Object> facts) {
		try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	//KieSession kSession = kContainer.newKieSession("ksession-process");
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	// iterate over facts and insert them individually
        	for(Object fact : facts) {
        		System.out.println(fact);
        		kSession.insert(fact);
        	}
        	
            // start a new process instance
            kSession.startProcess("cukes_test");
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
	}

	public ArrayList<Object> getFacts() {
		return facts;
	}

	public void setFacts(ArrayList<Object> facts) {
		this.facts = facts;
	}
	
	
}
