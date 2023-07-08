package controller;

import View.Validation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

import model.Customer;
import model.Room.Room;

public class OrderManagement {
    public OrderManagement() {
        Scanner sc = new Scanner(System.in);
    }
    public static ArrayList<Customer> customerOrder = new ArrayList<>();
    // -----------------------------------------------------------
    public boolean OrderRoom() {
        String id = Validation.getString("Enter customer's id: ", "^KH\\d{4}+$");
        String name = Validation.getString("Enter customer's name: ", "[a-zA-Z ]+$");
        String phone = Validation.getString("Enter customer's phone:", "^0\\d{9}+$");
        String genderStr = Validation.getString("Enter customer's gender (true = male;false = female):", "true|false+$");
        boolean gender = Boolean.parseBoolean(genderStr);
        LocalDate dateOfBirthStr = Validation.getDate("Enter customer's date of birth: ");
        String email = Validation.getString("Enter customer's email: ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Room room = new Room();
//        do {
//        String roomId = val.getString("Enter room id of customer: ", "[0-9]");
//        if (!room.isIsRented()) {
//            customer.setRoomId(roomId);
//            break;
//        } else {
//        System.out.println("This room has been rented.");
//        }
//}       while (room.isIsRented());
        return false;
    }

    // ----------------------------------------------------------
    public void displayAllOrder(ArrayList<Customer> customerOrder) {
        customerOrder.forEach(p -> System.out.println(p));
    }
    // ---------------------------------------------------------

    public ArrayList<Customer> search(Predicate<Customer> p) {
        ArrayList<Customer> rs = new ArrayList<>();
        for (Customer s : customerOrder) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
    }
    // -------------------------------------------------------
    public boolean updateCustomer(Customer customer, String id, String name, String phone, LocalDate dateOfBirth, String address, String gender, String email, Room room) {
        boolean updated = false;
    
        if (id != null) {
            customer.setId(id);
            updated = true;
        }
        if (name != null) {
            customer.setName(name);
            updated = true;
        }
        if (phone != null) {
            customer.setPhone(phone);
            updated = true;
        }
        if (dateOfBirth != null) {
            customer.setDateOfBirth(dateOfBirth);
            updated = true;
        }
        if (address != null) {
            customer.setAddress(address);
            updated = true;
        }
        if (gender != null) {
            boolean parsedGender = Boolean.parseBoolean(gender);
            customer.setGender(parsedGender);
            updated = true;
        }
        if (email != null) {
            customer.setEmail(email);
            updated = true;
        }
        if (room != null) {
            customer.setRoom(room);
            updated = true;
        }
        
        return updated;
    }
    // --------------------------------------------------------
    public boolean deleteOrder(String id) {
        Customer customerToDelete = new Customer();
        for (Customer customer : customerOrder) {
            if (customer.getId().equalsIgnoreCase(id)) {
                customerToDelete = customer;
                break;
            }
        }
        if (customerToDelete == null)
            return false;
        String confirmation = "";
        do {
            confirmation = Validation.getString("Are you sure you want to delete the customer? (Yes/No): ");

            if (confirmation.equalsIgnoreCase("Yes")) {
                customerOrder.remove(customerToDelete);
                return true;
            } else if (confirmation.equalsIgnoreCase("No")) {
                System.out.println("Customer not deleted.");
                return false;
            } else {
                System.out.println("Invalid input. Customer not deleted.");
                return false;
            }
        } while (!confirmation.equalsIgnoreCase("Yes") && !confirmation.equalsIgnoreCase("No"));
    }

    // -----------------------------------------------------------
    public void sortOrder() {
        Collections.sort(customerOrder, Comparator.comparingInt(Customer::getDayRent));
    }
}
