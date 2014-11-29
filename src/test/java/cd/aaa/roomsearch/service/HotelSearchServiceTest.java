package cd.aaa.roomsearch.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cd.aaa.roomsearch.entity.Hotel;
import cd.aaa.roomsearch.entity.Room;
import cd.aaa.roomsearch.service.RandomAvailabilityService;
import cd.aaa.roomsearch.service.RandomHotelSearchService;

import com.google.gson.Gson;

public class HotelSearchServiceTest {

  RandomHotelSearchService service = new RandomHotelSearchService();
  RandomAvailabilityService availabilityService = new RandomAvailabilityService();

  @Test
  public void invokeHotelsFor() {
    List<Hotel> hotelsAt = service.getHotelsAt("bangalore");

    System.err.println(hotelsAt.size());

    Gson gson = new Gson();
    String result = gson.toJson(hotelsAt);

    System.out.println(result);

  }

  @Test
  public void invokeRoomAvailability() {
    List<Hotel> hotelsAt = service.getHotelsAt("bangalore");
    List<Long> roomIds = new ArrayList<Long>();

    System.err.println("number of hotels >> " + hotelsAt.size());

    for (Hotel h : hotelsAt) {
      for (Room r : h.getRooms()) {
        roomIds.add(r.getId());
      }
    }

    System.out.println("rooms >> " + roomIds.size());

    System.out.println(availabilityService.getAvailability(roomIds, null, null));
  }

}
