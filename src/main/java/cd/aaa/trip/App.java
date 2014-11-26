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

    // http://localhost:4567/hello-world
    get("/hello", (req, res) -> "<h1>yeah the app works.. </h1>"
        + "<h2>These are the 2 services which are exposed. </h2>"
        + "<li>http://localhost:4567/search/bydestination?destination=blr</li> "
        + "<li>http://localhost:4567/search/availability?rooms=74,75,77,89,10009&from=2014-04-01&to=2014-04-05");

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
      if (rooms == null || rooms.length < 1) {
        throw new IllegalArgumentException("http param rooms is required");
      }

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
