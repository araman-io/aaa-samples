package cd.aaa.trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import cd.aaa.trip.entity.Hotel;
import cd.aaa.trip.service.AvailabilityService;
import cd.aaa.trip.service.HotelSearchService;

import com.google.gson.Gson;

public class App {


  public static void main(String[] args) {

    HotelSearchService hotelSearchService = new HotelSearchService();

    AvailabilityService availabilityService = new AvailabilityService();

    get("/hello-world", (req, res) -> "yeah the app works.. ");

    get("/search/bydestination", (request, response) -> {
      String destination = request.queryParams("destination");
      List<Hotel> hotelsAt = hotelSearchService.getHotelsAt(destination);
      Gson gson = new Gson();
      String result = gson.toJson(hotelsAt);
      return result;
    });


    get("/search/availability", (request, response) -> {

      List<Long> roomIds = new ArrayList<Long>();

      String[] rooms = request.queryParams("rooms").split(",");

      for (int i = 0; i < rooms.length; i++) {
        roomIds.add(Long.valueOf(rooms[i]));
      }

      Map<Long, Boolean> availabilityMap = availabilityService.getAvailability(roomIds, null, null);

      Gson gson = new Gson();
      String result = gson.toJson(availabilityMap);

      return result;

    });

  }

}
