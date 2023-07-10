package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Room.CoupleRoom;
import model.Room.Room;
import model.Room.SingleRoom;

public class RoomManagement {
    public static ArrayList<Room> rooms = new ArrayList<>();;
    protected Scanner sc = new Scanner(System.in);;

    public RoomManagement() {
        createRoom();
    };

    public void createRoom() {
        for (int i = 0; i < 10; i++) {
            Room singleRoom = new SingleRoom();
            Room coupleRoom = new CoupleRoom();
            rooms.add(singleRoom);
            rooms.add(coupleRoom);
        }
        sortRoomByID();
    }

    public ArrayList<Room> getRentedRoom() {
        ArrayList<Room> rs = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isIsRented()) {
                rs.add(room);
            }
        }
        return rs;
    }

    public void display() {
        rooms.forEach(p -> System.out.println(p));
    }

    public Room rentRoomByType(String choice) {
        for(Room room: rooms) {
            if(!room.isIsRented() && choice.equals("1") && room.getRoomType().equals("Single Room")){
                room.setIsRented(true);
                return room;
            } else if(!room.isIsRented() && choice.equals("2") && room.getRoomType().equals("Couple Room")){
                room.setIsRented(true);
                return room;
            }
        }
        return null;
    }
    
    public Room rentRoomById(String id) {
        for(Room room: rooms) {
            if(!room.isIsRented() && room.getRoomID().equalsIgnoreCase(id)){
                room.setIsRented(true);
                return room;
            } else if(!room.isIsRented() && room.getRoomID().equalsIgnoreCase(id)){
                room.setIsRented(true);
                return room;
            }
        }
        return null;
    }

    public boolean updateRoomPrice(String id, float price) {
        for (Room room : rooms) {
            if (room.getRoomID().equalsIgnoreCase(id)) {
                room.setPrice(price);
                return true;
            }
        }
        return false;
    }

    public Room searchRoomById(String id) {
        return rooms.stream()
                .filter(p -> p.getRoomID().equals(id))
                .findFirst().orElse(null);
    }

    public boolean deleteRoomStatus(String id) {
        for (Room room : rooms) {
            if (room.getRoomID.equals(id)) {
                room.setIsRented(false);
                return true;
            }
        }
        return false;
    }

    public void sortRoomByID() {
        Collections.sort(rooms, Comparator.comparing(Room::getRoomID));
    }

}
