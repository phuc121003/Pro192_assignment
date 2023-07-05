package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Room;

public class RoomManagement {
    ArrayList<Room> rooms = new ArrayList<>();

    public void loadDataFile() {
        try {
            String fileName = "Room.txt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Room room = new Room(data[0], data[1], data[2], data[3]);
                    rooms.add(room);
                }
            }
            br.close();
            System.out.println("Data loaded from" + fileName + "successfully");
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private void clearDataFile() {
        try {
            String fileName = "Room.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(""); 
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataFile() {
        try {
            String fileName = "Room.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (Room room : rooms) {
                bw.write(room.getRoomID() + ", " + room.getRoomType() + ", " + room.getStatus() + ", "
                        + room.getPrice());
                bw.newLine();
            }
            bw.close();
            System.out.println("Data has been written to " + fileName + " successfully.");
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    private void deleteDataFile(String roomID) {

    File file = new File("Room.txt");
    if (file.exists()) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(roomID)) {
                    lines.add(line);
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("Data file updated.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Data file not found.");
    }
}


    public ArrayList<Room> getRoom() {
        if (rooms.isEmpty()) {
            loadDataFile();
        }
        return rooms;
    }

    public void addRoom(Room room) {
        clearDataFile();
        rooms.add(room);
        writeDataFile();
    }

    public void updateRoomID(String roomID, String newRoomID) {
        ArrayList<Room> rooms = searchRoomByID(roomID);
        if (!rooms.isEmpty()) {
            clearDataFile();
            for (Room room : rooms) {
                room.setRoomID(newRoomID);
            }
            writeDataFile();
        } else {
            System.out.println("Room ID not found");
        }
    }

    public void updateRoomType(String roomID, String newRoomType) {
        ArrayList<Room> rooms = searchRoomByID(roomID);
        if (!rooms.isEmpty()) {
            clearDataFile();
            for (Room room : rooms) {
                room.setRoomType(newRoomType);
            }
            writeDataFile();
        } else {
            System.out.println("Room ID not found");
        }
    }

    public void updateStatus(String roomID, String newStatus) {
        ArrayList<Room> rooms = searchRoomByID(roomID);
        if (!rooms.isEmpty()) {
            clearDataFile();
            for (Room room : rooms) {
                room.setStatus(newStatus);
            }
            writeDataFile();
        } else {
            System.out.println("Room ID not found");
        }
    }

    public void updatePrice(String roomID, String newPrice) {
        ArrayList<Room> rooms = searchRoomByID(roomID);
        if (!rooms.isEmpty()) {
            clearDataFile();
            for (Room room : rooms) {
                room.setPrice(newPrice);
            }
            writeDataFile();
        } else {
            System.out.println("Room ID not found");
        }
    }

    public ArrayList<Room> searchRoomByID(String roomID) {
        ArrayList<Room> searchRoom = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) {
                searchRoom.add(room);
            }
        }
        return searchRoom;
    }

    public ArrayList<Room> searchRoomByType(String roomType) {
        ArrayList<Room> searchRoom = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equals(roomType)) {
                searchRoom.add(room);
            }
        }
        return searchRoom;
    }

    public ArrayList<Room> searchRoomByStatus(String status) {
        ArrayList<Room> searchRoom = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getStatus().equals(status)) {
                searchRoom.add(room);
            }
        }
        return searchRoom;
    }

    public ArrayList<Room> searhRoomByPrice(String price) {
        ArrayList<Room> searchRoom = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getStatus().equals(price)) {
                searchRoom.add(room);
            }
        }
        return searchRoom;
    }

    public void deleteRoom(String roomID) {
        ArrayList<Room> roomToRemove = searchRoomByID(roomID);
        if (!roomToRemove.isEmpty()) {
            rooms.removeAll(roomToRemove);
            deleteDataFile(roomID);
        } else {
            System.out.println("Room not found");
        }
    }

}
