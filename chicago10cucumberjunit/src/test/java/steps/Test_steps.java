package steps;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test_steps {

    @When("user goes to google application")
    public void user_goes_to_google_application() {
        System.out.println("selenium is going to Google.com");

    }

    @Then("user searhes for apple")
    public void user_searhes_for_apple() {
        System.out.println("user esarching for a word apple");

    }

    @Then("user should see apple realted results")
    public void user_should_see_apple_related_results() {
        System.out.println("user checking the results of search");
        Assert.fail("failing for reason");


    }


}
