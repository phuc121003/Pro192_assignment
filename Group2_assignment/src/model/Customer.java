
package model;

import model.Room.Room;
import java.time.LocalDate;

public class Customer extends Person{
    private String billID;
    private int dayRent;
    private Room room;

    public Customer(String id, String name, String phone, LocalDate dateOfBirth,String billID, int dayRent, Room room) {
        super(id, name, phone, dateOfBirth);
        this.billID = billID;
        this.dayRent = dayRent;
    }

    public Customer() {
    }

    public String getBillID() {
        return billID;
    }

    public int getDayRent() {
        return dayRent;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public void setDayRent(int dayRent) {
        this.dayRent = dayRent;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.getId() + ", name=" + this.getName() + ", phone=" + this.getPhone()+ ", dateOfBirth=" + this.getDateOfBirth() + "billID=" + billID + ", dayRent=" + dayRent + '}';
    }
}
