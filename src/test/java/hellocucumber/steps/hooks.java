package hellocucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class hooks {

	private static final Logger LOG = LogManager.getLogger(hooks.class);
	
	@Before
	public void testStart(Scenario scenario) {
		LOG.info("*****************************************************************************************");
		LOG.info("	Scenario: "+scenario.getName());
		LOG.info("*****************************************************************************************");
	}
}
