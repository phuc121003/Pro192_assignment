
package model;

import java.time.LocalDate;

public class Customer extends Person{
    private String billID;
    private int dayRent;

    public Customer(String id, String name, String phone, String address, boolean gender, LocalDate dateOfBirth,String billID, int dayRent) {
        super(id, name, phone, address, gender, dateOfBirth);
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
        return "Customer{" + "id=" + this.getId() + ", name=" + this.getName() + ", phone=" + this.getPhone()+ ", address=" + this.getAddress() + ", gender=" + this.isGender() + ", dateOfBirth=" + this.getDateOfBirth() + "billID=" + billID + ", dayRent=" + dayRent + '}';
    }
}
