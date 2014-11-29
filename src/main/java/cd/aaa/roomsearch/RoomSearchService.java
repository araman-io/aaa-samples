package cd.aaa.roomsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cd.aaa.roomsearch.entity.Hotel;
import cd.aaa.roomsearch.entity.Room;
import cd.aaa.roomsearch.entity.RoomSearchRequest;
import cd.aaa.roomsearch.service.AvailabilityService;
import cd.aaa.roomsearch.service.HotelSearchService;

public class RoomSearchService {
	
	HotelSearchService hotelService = new HotelSearchService();
	AvailabilityService availabilityService = new AvailabilityService();

	public List<Hotel> getAvailableRooms(RoomSearchRequest request) {
		
		//first find hotels
		List<Hotel> hotelsAtDestination = hotelService.getHotelsAt(request.getDestination());
		
		//then find available rooms in hotels
		for ( Hotel h : hotelsAtDestination ) {
			List<Long> roomIds = this.getRoomIds(h.getRooms());
			Map<Long, Boolean> availability = availabilityService.getAvailability(roomIds, request.getFromDate(), request.getToDate());
			
			//iterate and set only available rooms
			List<Room> availableRooms = new ArrayList<Room>();
			for ( Room r : h.getRooms() ) {
				if ( availability.get(r.getId()) ) {
					//room is available
					availableRooms.add(r);
				}
			}
			h.setRooms(availableRooms);
		}
		
		return hotelsAtDestination;

	}
	
	protected List<Long> getRoomIds(List<Room> rooms) {
		List<Long> ids = new ArrayList<Long>();
		for (Room r : rooms) {
			ids.add(r.getId());
		}
		return ids;
	}
	
}
