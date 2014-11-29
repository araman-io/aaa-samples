package cd.aaa.roomsearch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cd.aaa.roomsearch.entity.Hotel;
import cd.aaa.roomsearch.entity.Room;
import cd.aaa.roomsearch.entity.RoomType;

public class HotelSearchService {

  String[] HOTEL_NAMES = new String[] {"Bristol Hotel", "Park Inn Hotel", "Taj Hotel", "WestInn Hotel",
      "BestInn Hotel", "Hyatt Hotel", "Regency Hotel", "Grand Hotel", "Plaza Hotel", "Fortune Hotel",
      "Country Inn Hotel", "Formule 1 Hotel", "Aloft Hotel", "Leela Hotel", "Windsor Hotel", "Clarks Inn Hotel",
      "Fern Hotel", "Lemon Tree Hotel", "Vivanta Hotel", "Radisson Hotel", "Oxford Hotel", "Novotel Hotel",
      "Ibis Hotel", "Hilton Hotel", "Ramada Hotel", "Marriot Hotel", "Premier Inn Hotel", "Double Tree Hotel",
      "Hotel 29", "Hotel 30", "Hotel 31", "Hotel 32", "Hotel 33", "Hotel 34", "Hotel 35", "Hotel 36", "Hotel 37",
      "Hotel 38", "Hotel 39", "Hotel 40", "Hotel 41", "Hotel 42", "Hotel 43", "Hotel 44", "Hotel 45", "Hotel 46",
      "Hotel 47", "Hotel 48", "Hotel 49", "Hotel 50"};

  public List<Hotel> getHotelsAt(String destination) {

    int numberOfHotels = (int) ((Math.random() * 100) % 25);

    List<Hotel> results = null;

    results = this.getHotels(numberOfHotels);

    return results;

  }

  protected List<Hotel> getHotels(int numberOfHotels) {

    int hotelIndex;
    int numberOfRooms;
    List<Hotel> hotels = new ArrayList<Hotel>();

    for (int i = 0; i < numberOfHotels; i++) {
      hotelIndex = getNextRandomPositiveInt() % 50;
      numberOfRooms = getNextRandomPositiveInt() % 5;
      Hotel h = new Hotel();
      h.setName(HOTEL_NAMES[hotelIndex]);
      h.setId(getNextRandomPositiveLong());
      h.setRooms(this.getRooms(numberOfRooms));
      hotels.add(h);
    }


    return hotels;
  }

  protected List<Room> getRooms(int count) {
    List<Room> rooms = new ArrayList<Room>();
    int startingRoomId = getNextRandomPositiveInt();
    if (count == 0) {
      count = 1;
    }

    for (int i = 0; i < count; i++) {
      Room r = new Room();
      r.setId(startingRoomId++);
      r.setDailyRate((double) getNextRandomPositiveLong());
      r.setRoomType(RoomType.values()[i]);

      rooms.add(r);
    }

    return rooms;

  }

  protected int getNextRandomPositiveInt() {

    int result = (int) (Math.random() * 100);
    if (result < 0) {
      result = -1 * result;
    }

    return result;
  }

  protected long getNextRandomPositiveLong() {

    long result = (long) (Math.random() * 100);
    if (result < 0) {
      result = -1 * result;
    }

    return result;
  }

}
