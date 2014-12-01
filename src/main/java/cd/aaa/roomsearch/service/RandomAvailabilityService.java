package cd.aaa.roomsearch.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomAvailabilityService {

	Random randomizer = new Random();

	public Map<Long, Boolean> getAvailability(List<Long> roomIds, String startDate, String endDate) {

		checkDates(startDate, endDate);

		Map<Long, Boolean> roomAvailability = new HashMap<Long, Boolean>();

		for (Long roomId : roomIds) {
			roomAvailability.put(roomId, randomizer.nextBoolean());
		}

		return roomAvailability;
	}

	public void checkDates(String startDate, String endDate) {
		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		long t1, t2, t3;
		try {
			t1 = format.parse(startDate).getTime();
			t2 = format.parse(endDate).getTime();
			t3 = System.currentTimeMillis();
		} catch (ParseException e) {
			throw new IllegalArgumentException("dates cant be parsed");		}

		if (!(t3 < t1 && t1 < t2)) {
			throw new IllegalArgumentException("something isnt right in the way dates are structured");
		}
	}

}
