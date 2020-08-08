package stepdef.Hotel;

import Pages.Hotel.HotelLandingPage;
import Pages.Hotel.RatingHotelPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HotelRatingSD {
    RatingHotelPage starPage = new RatingHotelPage();
    HotelLandingPage landingPage = new HotelLandingPage();

    @Given("^I typed in (.+) into the search bar$")
    public void i_typed_in_New_York_into_the_search_bar( String city) {
    landingPage.typedCity(city);
    }

    @Given("^I select (.+) from auto-suggestions$")
    public void i_select_New_York_New_York_United_States_of_America_from_auto_suggestions( String city) throws InterruptedException {
        landingPage.autoSug(city);

    }
    @Given("^I press the search button$")
    public void i_press_the_search_button() throws InterruptedException {
        landingPage.submit();
        Thread.sleep(3000);
    }

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() {


    }

    @When("^I click on (\\d+) star$")
    public void i_click_on_star(int arg1) throws InterruptedException {
        starPage.scrollToStarRating();
        starPage.clickOnStarRating(arg1);
    }

    @When("^I verify hotels are (\\d+) star rating$")
    public void i_verify_hotels_are_star_rating(int arg1) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(starPage.starResultCheck(arg1));



    }

}
