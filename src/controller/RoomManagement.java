package controller;

import View.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Room.CoupleRoom;
import model.Room.Room;
import model.Room.SingleRoom;

public class RoomManagement extends Menu<String>{
    private ArrayList<Room> rooms = new ArrayList<>();
    protected Scanner sc = new Scanner(System.in);
    static String[] mainMenuOptions = { "Display rented room", "Add new room", "Search room", "Delete room by ID", "Update room", "Exit!" };
    public RoomManagement() {
        super("Room Management System", mainMenuOptions); 
    }
    @Override
    public void execute(String selected) {
        Room[] singleRoom = new SingleRoom[10];
        Room[] coupleRoom = new CoupleRoom[10];
        for(int i=0; i<10; i++) {
            singleRoom[i] = new SingleRoom();
            coupleRoom[i] = new CoupleRoom();
            rooms.add(singleRoom[i]);
            rooms.add(coupleRoom[i]);
        }
        sortRoomByID();
        switch (selected) {
            case "1":
                displayRentedRoom();
                break;
            case "2":
                rentRoom();
                break;
            case "3":
//                searchRoom();
                break;
            case "4":
//                deleteRoomByID();
                break;
            case "5":
//                updateRoom(this);
                break;
            case "6":
                System.out.println("Goodbye!");
                System.exit(0);
        }
    }
    public List<Room> roomRented() {
        return rooms.stream().filter(p -> p.isIsRented()==true)
                .collect(Collectors.toList());
    }
    public void displayRentedRoom() {
        if(roomRented().isEmpty()) {
            System.out.println("No room is rented");
        } else {
                System.out.println("----------------------------------------------------------");
                System.out.println("|Room ID \t RoomType \t Price \t isRented|");
                    rooms.stream()
                            .filter(room -> room.isIsRented()==true)
                            .forEach(room -> System.out.println(room));
                System.out.println("-----------------------------------------------------------");
        }

    }

    public void displaySearchResult(List<Room> searchRooms) {
        System.out.println("List of Customers");
        System.out.println("---------------------------------------");
        for (Room room : searchRooms) {
            System.out.println(room);
        }
        System.out.println("---------------------------------------");
        System.out.println("Total: " + searchRooms.size() + " customers.");
    }
    
    public void rentRoom() {
        String[] roomTypeOptions = {"Single Room", "Couple Room", "Exit"};
        Menu roomType = new Menu("Enter Room Type: ", roomTypeOptions) {
            @Override
            public void execute(String selected) {
                switch (selected) {
                    case "1":
                        for(Room room : rooms) {
                            if(room.getRoomType().equalsIgnoreCase("single room") && room.isIsRented()== false) {
                                room.setIsRented(true);
                                break;
                            }
                        }
                        break;
                    case "2":
                        for(Room room : rooms) {
                            if(room.getRoomType().equalsIgnoreCase("couple room") && room.isIsRented()==false) {
                                room.setIsRented(true);
                                break;
                            }
                        }
                        break;
                    case "3": 
                        return;
                    default:
                        System.out.println("Invalid, re-enter please!");
                }
            }
        };
        roomType.run();
    }
    
//    public void loadDataFile() {
//        try {
//            String fileName = "Room.txt";
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] data = line.split(",");
//                if (data.length == 4) {
//                    Room room = new Room(data[0], data[1], Float.parseFloat(data[2]), Boolean.parseBoolean(data[3]));
//                    rooms.add(room);
//                }
//            }
//            br.close();
//            System.out.println("Data loaded from" + fileName + "successfully");
//        } catch (IOException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//    }
//    public void writeDataFile() {
//        String fileName = "Room.txt";
//        BufferedWriter bw;
//        try {
//            bw = new BufferedWriter(new FileWriter(fileName));
//            for (Room room : rooms) {
//                bw.write(room.getRoomID() + ", " + room.getRoomType() +", " + room.getPrice() + ", " + room.isIsRented());
//                bw.newLine();
//            }
//            bw.close();
//            System.out.println("Data has been written to " + fileName + " successfully.");
//        } catch (IOException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//    }
//    public void clearDataFile() {
//        String fileName = "Room.txt";
//        BufferedWriter bw;
//        try {
//            bw = new BufferedWriter(new FileWriter(fileName));
//            bw.write(""); 
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void deleteDataFile(String roomID) {
//    BufferedReader reader;
//    BufferedWriter writer;
//    File file = new File("Room.txt");
//    if (file.exists()) {
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            ArrayList<String> lines = new ArrayList<>();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (!line.contains(roomID)) {
//                    lines.add(line);
//                }
//            }
//            reader.close();
//            writer = new BufferedWriter(new FileWriter(file));
//            for (String updatedLine : lines) {
//                writer.write(updatedLine);
//                writer.newLine();
//            }
//            writer.close();
//
//            System.out.println("Data file updated.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    } else {
//        System.out.println("Data file not found.");
//    }
//}
//    
    public void sortRoomByID() {
        Collections.sort(rooms, (Room o1, Room o2) -> o1.getRoomID().compareTo(o2.getRoomID()));
    }
    
    
}