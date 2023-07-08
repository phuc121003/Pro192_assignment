package model;

import model.Room.Room;

public class Order {
    private Customer customer;
    private Room room;

    public Order(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return customer.toString() + ", " + room.toString();
    }
}
