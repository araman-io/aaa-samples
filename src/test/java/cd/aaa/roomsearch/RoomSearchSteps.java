package cd.aaa.roomsearch;

import java.util.List;

import static org.junit.Assert.*;

import sun.print.resources.serviceui;
import cd.aaa.roomsearch.entity.Hotel;
import cd.aaa.roomsearch.entity.RoomSearchRequest;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoomSearchSteps {
	
	private RoomSearchRequest request = null;
	RoomSearchService searchService = new RoomSearchService();
	
	@Given("A Guest Trying to Find Rooms") 
	public void initSearch() {
		request = new RoomSearchRequest();
	}
	
	@When("They Enter (.+) as the destination")
	public void setDestination(String destination) {
		System.out.println(request);
		request.setDestination(destination);
	}
	
	@And("(.+) , (.+) as from and to Dates")
	public void setDates(String from, String to) {
		request.setFromDate(from);
		request.setToDate(to);
	}
	
	@Then("We should Return some results")
	public void searchForProperties() {
		List<Hotel> availableRooms = searchService.getAvailableRooms(request);
		assertNotNull(availableRooms);
		assertTrue(availableRooms.size() > 10);
	}
	
    @Before
    public void before() {
        System.out.println("Scenario about to be run");
    }

    @After
    public void after() {
        System.out.println("Scenario finished running");
    }
    
    @Then("^We should Return an error message$")
    public void we_should_Return_an_error_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
