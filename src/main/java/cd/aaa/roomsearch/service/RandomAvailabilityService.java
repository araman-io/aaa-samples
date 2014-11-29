package cd.aaa.roomsearch.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class RandomAvailabilityService {
  
  Random randomizer = new Random();

  
  public Map<Long, Boolean> getAvailability(List<Long> roomIds, String startDate, String endDate) {
    
    Map<Long, Boolean> roomAvailability = new HashMap<Long, Boolean>();
    
    for ( Long roomId : roomIds ) {
      roomAvailability.put(roomId, randomizer.nextBoolean());
    }
    
    return roomAvailability;
  }
  

}
