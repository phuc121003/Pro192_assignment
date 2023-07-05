package model;

public class Room {

    private String roomID;
    private String roomType;
    private String status;
    private String price;

    public Room(String roomID, String roomType, String status, String price) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [roomID=" + roomID + ", roomType=" + roomType + ", status=" + status + ", price=" + price + "]";
    }
}
