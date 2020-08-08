package stepdef.Hotel;

import Drives.Web;
import Pages.Hotel.HotelLandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HotelSD {
    HotelLandingPage hotelPage = new HotelLandingPage();

    @Given("^I am on hotels landing page$")
    public void i_am_on_hotels_landing_page() {
        Web.initDriver("https://www.hotels.com/");
    }

    @When("^I select (\\d+) in children dropdown$")
    public void i_select_in_children_dropdown(int arg1) {
       hotelPage.clickOnChildDropDown(arg1);
    }


    @Then("^I see (\\d+) child age dropdowns$")
    public void i_see_child_age_dropdowns(int arg1) {
        hotelPage.getTotalChildDropDownInList();
        Assert.assertEquals( hotelPage.getTotalChildDropDownInList(),arg1,"Numbers did not match");
    }
}
