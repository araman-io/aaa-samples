package cd.aaa.roomsearch;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import cd.aaa.roomsearch.entity.Hotel;
import cd.aaa.roomsearch.entity.RoomSearchRequest;

public class RoomSearchIntegrationTest {

	@Test(expected = IllegalArgumentException.class)
	public void hotelServiceDoesntLikeNullDestination() {
		RoomSearchRequest request = new RoomSearchRequest();
		RoomSearchFacade facade = new RoomSearchFacade();

		facade.getAvailableRooms(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void hotelServiceDoesntLikeZimbaAsDestination() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("zimba");
		RoomSearchFacade facade = new RoomSearchFacade();

		facade.getAvailableRooms(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void availabilityServiceDoesntLikeDatesInPast() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("1-dec-1998");
		request.setToDate("15-dec-1998");

		RoomSearchFacade facade = new RoomSearchFacade();
		facade.getAvailableRooms(request);
	}

	@Test(expected = IllegalArgumentException.class)
	public void availabilityServiceDoesntLikeUnorderedDates() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("15-dec-2015");
		request.setToDate("1-dec-2015");

		RoomSearchFacade facade = new RoomSearchFacade();
		facade.getAvailableRooms(request);
	}

	@Test
	public void wellFormedCallsShouldReturnHotelResults() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("1-dec-2015");
		request.setToDate("5-dec-2015");

		RoomSearchFacade facade = new RoomSearchFacade();
		List<Hotel> availableHotelRooms = facade.getAvailableRooms(request);

		assertTrue(availableHotelRooms.size() > 1);
	}

}
