package view;

import View.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.RoomManagement;
import model.Room.Room;

public class MenuRoom {
    private final RoomManagement roomManagement;
    private final Scanner scanner;

    public MenuRoom() {
        roomManagement = new RoomManagement();
        scanner = new Scanner(System.in);
    }

    private void displayAllRoom() {
        ArrayList<Room> rooms = roomManagement.getRoom();
        System.out.println("List of room: ");
        System.out.println("---------------------------------------");
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println("---------------------------------------");
        System.out.println("Total: " + rooms.size() + " rooms.");
    }


    private void displaySearchResult(List<Room> searchRooms) {
        System.out.println("List of Customers");
        System.out.println("---------------------------------------");
        for (Room room : searchRooms) {
            System.out.println(room);
        }
        System.out.println("---------------------------------------");
        System.out.println("Total: " + searchRooms.size() + " customers.");
    }

    

    private void deleteRoomByID() {
        System.out.println("Enter ID to delete:");
        String roomID = scanner.nextLine();
        if (roomManagement.searchRoomByID(roomID).isEmpty()) {
            System.out.println("No delete can be performed!");
        } else {
            roomManagement.deleteRoom(roomID);
            System.out.println("Succesful!");
        }
    }

    private void searchRoomByID() {
        System.out.println("Enter Room ID: ");
        String roomID = scanner.nextLine();
        ArrayList<Room> searchRooms = roomManagement.searchRoomByID(roomID);
        if (searchRooms.isEmpty()) {
            System.out.println("List empty");
        } else {
            displaySearchResult(searchRooms);
        }
    }

    public void searchRoomByType() {

        System.out.println("Enter Room Type:");
        System.out.println("1. Single Room");
        System.out.println("2. Couple Room");
        int roomTypeChoice;
        String roomType;
        do {
            roomTypeChoice = scanner.nextInt();
            scanner.nextLine();
            switch (roomTypeChoice) {
                case 1:
                    roomType = "Single Room";
                    break;
                case 2:
                    roomType = "Couple Room";
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid room type.");
                    roomType = null;
                    break;
            }
        } while (roomType == null);

        ArrayList<Room> searchRooms = roomManagement.searchRoomByType(roomType);
        if (searchRooms.isEmpty()) {
            System.out.println("List empty");
        } else {
            displaySearchResult(searchRooms);
        }
    }

    private void searchRoomByStatus() {

        System.out.println("Enter Status:");
        System.out.println("1. Rented room");
        System.out.println("2. Unrented room");
        int statusChoice;
        String status;
        do {
            statusChoice = scanner.nextInt();
            scanner.nextLine();
            switch (statusChoice) {
                case 1:
                    status = "Rented room";
                    break;
                case 2:
                    status = "Unrented room";
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid status.");
                    status = null;
                    break;
            }
        } while (status == null);

        ArrayList<Room> searchRooms = roomManagement.searchRoomByStatus(status);
        if (searchRooms.isEmpty()) {
            System.out.println("List empty");
        } else {
            displaySearchResult(searchRooms);
        }
    }

    private void searchRoomByPrice() {

        System.out.println("Enter Room Price:");
        System.out.println("1. 100.0$");
        System.out.println("2. 170.0$");
        int roomTypeChoice;
        String price;

        do {
            roomTypeChoice = scanner.nextInt();
            scanner.nextLine();

            switch (roomTypeChoice) {
                case 1:
                    price = "100.0";
                    break;
                case 2:
                    price = "170.0";
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid room type.");
                    price = "0";
                    break;
            }
        } while (price.equals("0"));

        ArrayList<Room> searchRooms = roomManagement.searhRoomByPrice(price);
        if (searchRooms.isEmpty()) {
            System.out.println("List empty");
        } else {
            displaySearchResult(searchRooms);
        }
    }

    private void searchRoom() {
        String[] searchMenuOptions = { "Find by RoomID", "Find by RoomType", "Find by RoomStatus", "Find by RoomPrice", "Return Menu" };
        Menu searchMenu = new Menu("Room Searching", searchMenuOptions) {
            @Override
            public void execute(String selected) {
                switch (selected) {
                    case "1":
                        searchRoomByID();
                        break;
                    case "2":
                        searchRoomByType();
                        break;
                    case "3":
                        searchRoomByStatus();
                        break;
                    case "4":
                        searchRoomByPrice();
                        break;
                    case "5":
                        return;
                }
            }
        };
        searchMenu.run();
    }

    private void updateRoom(Menu<String> mainMenu) {

        String[] updateMenuOptions = { "Update RoomID", "Update RoomType", "Update Status", "Update Price", "Return Menu" };
        Menu updateMenu = new Menu("Customer Searching", updateMenuOptions) {
            @Override
            public void execute(String selected) {
                String roomID = null, roomType = null, status = null, price = null;

                switch (selected) {
                    case "1":
                        System.out.println("Enter RoomID to update: ");
                        roomID = scanner.nextLine();
                        System.out.println("Enter new RoomID:");
                        String newroomID = scanner.nextLine();
                        roomManagement.updateRoomID(roomID, newroomID);
                        break;
                    case "2":
                        System.out.println("Enter RoomID to update: ");
                        roomID = scanner.nextLine();
                        System.out.println("Enter New Room Type:");
                        System.out.println("1. Single Room");
                        System.out.println("2. Couple Room");
                        System.out.println("3. Return Menu");
                        roomType = null;
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                roomType = "Single Room";
                                break;
                            case 2:
                                roomType = "Couple Room";
                                break;
                            case 3:
                                mainMenu.run();
                                break;
                            default:
                                System.out.println("Invalid choice. No Room Type will be updated.");
                                break;
                        }

                        if (roomType != null) {
                            roomManagement.updateRoomType(roomID, roomType);
                        }

                        break;
                    case "3":
                        System.out.println("Enter RoomID to update: ");
                        roomID = scanner.nextLine();
                        System.out.println("Enter New Status:");
                        System.out.println("1. Rented room");
                        System.out.println("2. Unrented room");
                        System.out.println("3. Return Menu");
                        status = null;
                        int choice1 = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice1) {
                            case 1:
                                status = "Rented room";
                                break;
                            case 2:
                                status = "Unrented room";
                                break;
                            case 3:
                                mainMenu.run();
                                break;
                            default:
                                System.out.println("Invalid choice. No Status will be updated.");
                                break;
                        }

                        if (status != null) {
                            roomManagement.updateStatus(roomID, status);
                        }

                        break;
                    case "4":
                        System.out.println("Enter RoomID to update: ");
                        roomID = scanner.nextLine();
                        System.out.println("Enter New Room Price:");
                        System.out.println("1. 100.0$");
                        System.out.println("2. 170.0$");
                        System.out.println("3. Return Menu");
                        price = null;
                        int choice3 = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (choice3) {
                            case 1:
                                price = "100.0$";
                                break;
                            case 2:
                                price = "170.0$";
                                break;
                            case 3:
                                mainMenu.run();
                                break;
                            default:
                                System.out.println("Invalid choice. No Price will be updated.");
                                break;
                        }

                        if (price != null) {
                            roomManagement.updatePrice(roomID, price);
                        }

                    case "5":
                        mainMenu.run();
                        break;
                }
            }
        };
        updateMenu.run();
    }

    public void run() {
        roomManagement.loadDataFile();
        String[] mainMenuOptions = { "Display all room", "Add new room", "Search room", "Delete room by ID", "Update room", "Exit!" };
        Menu mainMenu = new Menu("Company Management System", mainMenuOptions) {
            @Override
            public void execute(String selected) {
                switch (selected) {
                    case "1":
                        displayAllRoom();
                        break;
                    case "2":
                        addNewRoom();
                        break;
                    case "3":
                        searchRoom();
                        break;
                    case "4":
                        deleteRoomByID();
                        break;
                    case "5":
                        updateRoom(this);
                        break;
                    case "6":
                        System.out.println("Goodbye!");
                        System.exit(0);
                }
            }

            private void addNewRoom() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        mainMenu.run();
    }

    public static void main(String[] args) {
        MenuRoom menuRoom = new MenuRoom();
        menuRoom.run();
    }
}
