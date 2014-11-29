package cd.aaa.roomsearch.entity;

public enum RoomType {
  
  SINGLE(1, 1), DOUBLE(2, 2), EXECUTIVE(1, 0), PRESIDENT(2, 2), BARN(7,0);
  
  int adults; 
  int children;
  
  RoomType(int adults, int children) {
    this.adults = adults;
    this.children = children;
  }

}
