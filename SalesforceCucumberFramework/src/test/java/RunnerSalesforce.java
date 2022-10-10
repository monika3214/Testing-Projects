

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
		"json:target/cucumber-reports/cucumber.json"
	
},

		features= {"src/test/resources/salesforceLogin.feature"},
		glue= {"com.steps"}
		)
public class RunnerSalesforce extends AbstractTestNGCucumberTests{

}
