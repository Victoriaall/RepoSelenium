package stepdef.Darksky;

import Drives.Web;
import Pages.Darksky.DarkskyLandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class DarkSkySD {
DarkskyLandingPage  darkTime = new DarkskyLandingPage();

    @Given("^I am on Darksky home page$")
    public void i_am_on_Darksky_home_page() {
        Web.initDriver("https://darksky.net/forecast/40.7127,-74.0059/us12/en");
    }

    @Then("^I verify timeline is displayed with (\\d+) hours increment$")
    public void i_verify_timeline_is_displayed_with_hours_increment(int arg1) {
        Assert.assertTrue(darkTime.twoHour(arg1));

    }
}

