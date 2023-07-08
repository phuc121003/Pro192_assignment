package model.Room;

public class Room {

    private String roomID;
    private String roomType;
    private float price;
    private boolean isRented = false;
    public Object getRoomID;

    public Room() {
    }

    public Room(String roomID, String roomType, float price, boolean isRented) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.price = price;
        this.isRented = isRented;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    @Override
    public String toString() {
        String status = isRented?"Occupied":"Vacant  ";
        return "|" + roomID + "\t" + roomType + "\t" + price + "\t" + status + "|";
    }

}
