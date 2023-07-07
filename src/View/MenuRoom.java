package View;

import java.util.Scanner;

import controller.RoomManagement;

public class MenuRoom extends Menu<String> {

    static String[] roomOptions = { "Display Rented Room.", "Rent Room.", "Update Price's Room.", "Search ID's Room.",
            "Delete Status's Room" };
    private RoomManagement roomManagement = new RoomManagement();
    Scanner sc = new Scanner(System.in);

    public MenuRoom() {
        super("Room Management System", roomOptions);
    }

    @Override
    public void execute(String selected) {
        switch (selected) {
            case "1":
                displayRentedRoom();
                break;
            case "2":
                rentRoom();
                break;
            case "3":
                updateRoomPrice();
                break;
            case "4":
                searchRoomById();
                break;
            case "5":
                deleteRoomStatus();
                break;
            default:
                System.out.println("Invalid, re-enter please!");
        }
    }

    public void displayRentedRoom() {
        if (roomManagement.getRentedRoom().isEmpty()) {
            System.out.println("Empty list, No display can be performed");
        } else {
            roomManagement.getRentedRoom().forEach(p -> System.out.println(p));
        }
    }

    public void rentRoom() {
        System.out.println("Enter type's room:");
        String typeRoom = sc.nextLine();
        if (roomManagement.rentRoom(typeRoom)) {
            System.out.println("Rented succesfull!");
        } else {
            System.out.println("Fault!");
        }
    }

    public void updateRoomPrice() {
        System.out.println("Enter id of room: ");
        String id = sc.nextLine();
        System.out.print("Enter price of the new Room : $");
        float priceNew = Float.parseFloat(sc.next());
        if (roomManagement.updateRoomPrice(id, priceNew)) {
            System.out.println("Update successfull!");
        } else {
            System.out.println("Fault!");
        }
    }

    public void searchRoomById() {
        System.out.println("Enter Id to find a specific room.");
        String id = sc.nextLine();

        if (roomManagement.searchRoomById(id).isEmpty()) {
            System.out.println("Empty list, No search can be performed!");
        } else {
            System.out.println(roomManagement.searchRoomById(id));
        }
    }

    public void deleteRoomStatus() {
        System.out.println("Enter ID's room: ");
        String idRoom = sc.nextLine();
        if (roomManagement.deleteRoomStatus(idRoom)) {
            System.out.println("Delete status succesfull!");
        } else {
            System.out.println("Fault, Can not change status's room!");
        }
    }
}