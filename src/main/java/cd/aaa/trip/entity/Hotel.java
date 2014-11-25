package cd.aaa.trip.entity;

import java.util.List;

public class Hotel {

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  @Override
  public String toString() {
    return "Hotel [id=" + id + ", name=" + name + ", rooms=" + rooms + "]";
  }

  long id;
  String name;
  List<Room> rooms;

}
