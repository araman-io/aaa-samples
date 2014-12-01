package cd.aaa.roomsearch;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import cd.aaa.roomsearch.entity.Hotel;
import cd.aaa.roomsearch.entity.Room;
import cd.aaa.roomsearch.entity.RoomSearchRequest;
import cd.aaa.roomsearch.entity.RoomType;
import cd.aaa.roomsearch.service.RandomAvailabilityService;
import cd.aaa.roomsearch.service.RandomHotelSearchService;

@RunWith(MockitoJUnitRunner.class)
public class RoomSearchFacadeTest {

	@Mock
	RandomAvailabilityService availabilityService;

	@Mock
	RandomHotelSearchService hotelSearchService;

	List<Hotel> hotels;
	List<Room> rooms;
	Map<Long, Boolean> availability;

	@Test
	public void shouldCallHotelSearchServiceWithTheDestinationSpecifiedOnRequest() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("1-dec-2015");
		request.setToDate("15-dec-2015");

		RoomSearchFacade facade = new RoomSearchFacade();
		facade.setSearchServices(hotelSearchService, availabilityService);
		facade.getAvailableRooms(request);

		verify(hotelSearchService).getHotelsAt("bangalore");
	}

	@Test
	public void shouldNotCallAvailabilityServiceWhenNoHotelsAreReturnedForDestination() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("1-dec-2015");
		request.setToDate("15-dec-2015");

		when(hotelSearchService.getHotelsAt("bangalore")).thenReturn(new ArrayList<Hotel>());

		RoomSearchFacade facade = new RoomSearchFacade();
		facade.setSearchServices(hotelSearchService, availabilityService);
		facade.getAvailableRooms(request);

		verify(hotelSearchService, times(1)).getHotelsAt("bangalore");
		verifyZeroInteractions(availabilityService);
	}

	@Test
	public void shouldCallAvailabilityServiceWithTheRoomsReturnedInTheHotelSearchCall() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("1-dec-2015");
		request.setToDate("15-dec-2015");

		when(hotelSearchService.getHotelsAt("bangalore")).thenReturn(hotels);
		when(
				availabilityService.getAvailability(Arrays.asList(new Long(12451), new Long(12452)), "1-dec-2015",
						"15-dec-2015")).thenReturn(availability);

		RoomSearchFacade facade = new RoomSearchFacade();
		facade.setSearchServices(hotelSearchService, availabilityService);
		facade.getAvailableRooms(request);

		verify(hotelSearchService, times(1)).getHotelsAt("bangalore");
		verify(availabilityService, times(1)).getAvailability(Arrays.asList(new Long(12451), new Long(12452)),
				"1-dec-2015", "15-dec-2015");

	}

	@Test
	public void shouldFilterOutUnavailableRooms() {
		RoomSearchRequest request = new RoomSearchRequest();
		request.setDestination("bangalore");
		request.setFromDate("1-dec-2015");
		request.setToDate("15-dec-2015");

		when(hotelSearchService.getHotelsAt("bangalore")).thenReturn(hotels);
		when(
				availabilityService.getAvailability(Arrays.asList(new Long(12451), new Long(12452)), "1-dec-2015",
						"15-dec-2015")).thenReturn(availability);

		RoomSearchFacade facade = new RoomSearchFacade();
		facade.setSearchServices(hotelSearchService, availabilityService);
		List<Hotel> filteredHotels = facade.getAvailableRooms(request);
		assertEquals(1, filteredHotels.size());
		assertEquals(1, filteredHotels.get(0).getRooms().size());
		assertEquals(RoomType.BARN, filteredHotels.get(0).getRooms().get(0).getRoomType());
		assertEquals(12452, filteredHotels.get(0).getRooms().get(0).getId());
	}

	@Before
	public void testData() {
		Room r1 = new Room();
		r1.setId(12451);
		r1.setRoomType(RoomType.SINGLE);
		r1.setDailyRate(new Double(34.56));

		Room r2 = new Room();
		r2.setId(12452);
		r2.setRoomType(RoomType.BARN);
		r2.setDailyRate(new Double(76.09));

		this.rooms = Arrays.asList(r1, r2);

		Hotel h = new Hotel();
		h.setId(1245);
		h.setName("dummy hotel");
		h.setRooms(rooms);

		this.hotels = Arrays.asList(h);

		this.availability = new HashMap<>();
		this.availability.put(new Long(12451), Boolean.FALSE);
		this.availability.put(new Long(12452), Boolean.TRUE);
	}

}
