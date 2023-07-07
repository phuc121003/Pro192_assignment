package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Room.CoupleRoom;
import model.Room.Room;
import model.Room.SingleRoom;

public class RoomManagement {
    protected ArrayList<Room> rooms = new ArrayList<>();;
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

    public boolean rentRoom(String roomType) {
        if (roomType.equalsIgnoreCase("single room")) {
            for (Room room : rooms) {
                if (room.getRoomType().equalsIgnoreCase("single room") && !room.isIsRented()) {
                    room.setIsRented(true);
                    return true;
                }
            }
        } else if (roomType.equalsIgnoreCase("couple room")) {
            for (Room room : rooms) {
                if (room.getRoomType().equalsIgnoreCase("couple room") && !room.isIsRented()) {
                    room.setIsRented(true);
                    return true;
                }
            }
        }
        return false;
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

    public List<Room> searchRoomById(String id) {
        return (List<Room>) rooms.stream()
                .filter(p -> p.getRoomID().equals(id))
                .collect(Collectors.toList());
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
