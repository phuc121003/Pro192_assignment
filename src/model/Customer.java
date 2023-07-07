
package model;

import java.time.LocalDate;
import model.Room.Room;

public class Customer extends Person{
    private Room room;
    private int dayRent;

    public Customer(String id, String name, String phone, String address, boolean gender, LocalDate dateOfBirth,String email,Room room, int dayRent) {
        super(id, name, phone, address, gender, dateOfBirth, email);
        this.room = room;
        this.dayRent = dayRent;
    }
    public Room getRoom() {
        return room;
    }

    public int getDayRent() {
        return dayRent;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDayRent(int dayRent) {
        this.dayRent = dayRent;
    }

    @Override
    public String toString() {
        String genderString = isGender() ? "male" : "female";
        return "|" + getId() + "\t" + getName() + "\t" + getPhone() + "\t" + genderString + "\t" + getDateOfBirth().getYear() + "\t" + getEmail() + "|"+room.getRoomID()+"\t"
        +room.getRoomType()+"\t"+"|"+room.getPrice();
    }

}
