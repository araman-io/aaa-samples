package cd.aaa.trip.entity;

public class Room {
  
  @Override
  public String toString() {
    return "Room [id=" + id + ", dailyRate=" + dailyRate + ", roomType=" + roomType + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Double getDailyRate() {
    return dailyRate;
  }

  public void setDailyRate(Double dailyRate) {
    this.dailyRate = dailyRate;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(RoomType roomType) {
    this.roomType = roomType;
  }

  long id;
  Double dailyRate;
  RoomType roomType;

}
