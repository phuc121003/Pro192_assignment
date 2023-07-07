package model;

import model.Room.Room;

public class Bill {
    int id;
    Customer customer;
    Room room;
    public Bill(int id, Customer customer, Room room) {
        this.id = id;
        this.customer = customer;
        this.room = room;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    @Override
    public String toString() {
        return "Bill [id=" + id + ", customer=" + customer + ", room=" + room + "]";
    }
    
}
